package com.jumore.zhxf.web.rest;

import static org.elasticsearch.index.query.QueryBuilders.queryStringQuery;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.inject.Inject;
import javax.servlet.ServletContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.support.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.codahale.metrics.annotation.Timed;
import com.jumore.zhxf.config.AppSystemProperties;
import com.jumore.zhxf.domain.Category;
import com.jumore.zhxf.domain.News;
import com.jumore.zhxf.repository.CategoryRepository;
import com.jumore.zhxf.repository.NewsRepository;
import com.jumore.zhxf.repository.search.NewsSearchRepository;
import com.jumore.zhxf.service.buddha.NewsService;
import com.jumore.zhxf.service.dto.NewsDTO;
import com.jumore.zhxf.service.mapper.NewsMapper;
import com.jumore.zhxf.web.rest.util.HeaderUtil;
import com.jumore.zhxf.web.rest.util.PaginationUtil;

import io.swagger.annotations.ApiParam;

/**
 * REST controller for managing News.
 */
@RestController
@RequestMapping("/api")
public class NewsResource {

	private final Logger log = LoggerFactory.getLogger(NewsResource.class);

	@Inject
	private NewsRepository newsRepository;

	@Inject
	private CategoryRepository categoryRepository;

	@Inject
	private NewsMapper newsMapper;

	@Inject
	private NewsSearchRepository newsSearchRepository;

	@Inject
	private NewsService newsService;

	@Inject
	ServletContext servletContext;

	@Autowired
	private AppSystemProperties appSystemProperties;

	/**
	 * POST /news : Create a new news.
	 *
	 * @param newsDTO
	 *            the newsDTO to create
	 * @return the ResponseEntity with status 201 (Created) and with body the
	 *         new newsDTO, or with status 400 (Bad Request) if the news has
	 *         already an ID
	 * @throws URISyntaxException
	 *             if the Location URI syntax is incorrect
	 */
	@PostMapping("/news")
	@Timed
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(value = { org.springframework.web.multipart.MultipartException.class })
	public ResponseEntity<NewsDTO> createNews(@RequestParam("file") MultipartFile userImage,
			RedirectAttributes redirectAttributes, NewsDTO newsDTO) throws URISyntaxException {

		log.debug("REST request to save News : {}", newsDTO);

		/** 获取文件的后缀* */
		String suffix = userImage.getOriginalFilename().substring(userImage.getOriginalFilename().lastIndexOf("."));
		/** 使用UUID生成文件名称* */
		String logImageName = UUID.randomUUID().toString() + suffix.replace(".", "-");// 构建文件名称
		/** 拼成完整的文件保存路径加文件* */

		String rootDirectory = appSystemProperties.getRoot();
		if (userImage != null && !userImage.isEmpty()) {
			try {
				File file = new File(rootDirectory + File.separator + logImageName);
				userImage.transferTo(file);
				newsDTO.setPicPath(logImageName);
			} catch (Exception e) {
				e.printStackTrace();
				return ResponseEntity.badRequest()
						.headers(HeaderUtil.createFailureAlert("news", newsDTO.getId().toString(), e.getMessage()))
						.body(null);

			}
		}

		News news = newsService.save(newsDTO);
		NewsDTO result = newsMapper.newsToNewsDTO(news);
		return ResponseEntity.created(new URI("/api/news/" + result.getId()))
				.headers(HeaderUtil.createEntityCreationAlert("news", result.getId().toString())).body(result);
	}

	/**
	 * PUT /news : Updates an existing news.
	 *
	 * @param newsDTO
	 *            the newsDTO to update
	 * @return the ResponseEntity with status 200 (OK) and with body the updated
	 *         newsDTO, or with status 400 (Bad Request) if the newsDTO is not
	 *         valid, or with status 500 (Internal Server Error) if the newsDTO
	 *         couldnt be updated
	 * @throws URISyntaxException
	 *             if the Location URI syntax is incorrect
	 */
	@PutMapping("/news")
	@Timed
	public ResponseEntity<NewsDTO> updateNews(@RequestParam(value = "file", required = false) MultipartFile userImage,
			RedirectAttributes redirectAttributes, NewsDTO newsDTO) throws URISyntaxException {
		log.debug("REST request to update News : {}", newsDTO);
		if (userImage != null) {
			/** 获取文件的后缀* */
			String suffix = userImage.getOriginalFilename().substring(userImage.getOriginalFilename().lastIndexOf("."));
			/** 使用UUID生成文件名称* */
			String logImageName = UUID.randomUUID().toString() + suffix.replace(".", "-");// 构建文件名称
			/** 拼成完整的文件保存路径加文件* */

			String rootDirectory = appSystemProperties.getRoot();
			if (userImage != null && !userImage.isEmpty()) {
				try {
					File file = new File(rootDirectory + File.separator + logImageName);
					userImage.transferTo(file);
					newsDTO.setPicPath(logImageName);
				} catch (Exception e) {
					return ResponseEntity.badRequest()
							.headers(HeaderUtil.createFailureAlert("news", newsDTO.getId().toString(), "")).body(null);

				}
			}

		}
		News news = newsService.update(newsDTO);
		NewsDTO result = newsMapper.newsToNewsDTO(news);
		newsSearchRepository.save(news);
		return ResponseEntity.ok().headers(HeaderUtil.createEntityUpdateAlert("news", newsDTO.getId().toString()))
				.body(result);
	}

	/**
	 * GET /news : get all the news.
	 *
	 * @param pageable
	 *            the pagination information
	 * @return the ResponseEntity with status 200 (OK) and the list of news in
	 *         body
	 * @throws URISyntaxException
	 *             if there is an error to generate the pagination HTTP headers
	 */
	@GetMapping("/news")
	@Timed
	public ResponseEntity<List<NewsDTO>> getAllNews(@ApiParam Pageable pageable) throws URISyntaxException {
		log.debug("REST request to get a page of News");
		Order[] orders = new Order[] { new Order(Direction.DESC, "createdTime") };
		PageRequest pageRequest = new PageRequest(pageable.getPageNumber(), pageable.getPageSize(), new Sort(orders));

		Page<News> page = newsRepository.findAll(pageRequest);
		HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/news");
		List<NewsDTO> newsDTOList = newsMapper.newsToNewsDTOs(page.getContent());
		for (NewsDTO newsDTO : newsDTOList) {
			Category category = categoryRepository.findOne(newsDTO.getCategoryId());
			newsDTO.setSecondName(category.getName());
			Category parentCategory = categoryRepository.findOne(category.getParentId());
			newsDTO.setFirstName(parentCategory.getName());
		}
		return new ResponseEntity<>(newsDTOList, headers, HttpStatus.OK);
	}

	/**
	 * GET /news/:id : get the "id" news.
	 *
	 * @param id
	 *            the id of the newsDTO to retrieve
	 * @return the ResponseEntity with status 200 (OK) and with body the
	 *         newsDTO, or with status 404 (Not Found)
	 */
	@GetMapping("/news/{id}")
	@Timed
	public ResponseEntity<NewsDTO> getNews(@PathVariable Long id) {
		log.debug("REST request to get News : {}", id);
		News news = newsRepository.findOne(id);
		NewsDTO newsDTO = newsMapper.newsToNewsDTO(news);
		return Optional.ofNullable(newsDTO).map(result -> new ResponseEntity<>(result, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	/**
	 * DELETE /news/:id : delete the "id" news.
	 *
	 * @param id
	 *            the id of the newsDTO to delete
	 * @return the ResponseEntity with status 200 (OK)
	 */
	@DeleteMapping("/news/{id}")
	@Timed
	public ResponseEntity<Void> deleteNews(@PathVariable Long id) {
		log.debug("REST request to delete News : {}", id);
		newsRepository.delete(id);
		newsSearchRepository.delete(id);
		return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert("news", id.toString())).build();
	}

	/**
	 * SEARCH /_search/news?query=:query : search for the news corresponding to
	 * the query.
	 *
	 * @param query
	 *            the query of the news search
	 * @param pageable
	 *            the pagination information
	 * @return the result of the search
	 * @throws URISyntaxException
	 *             if there is an error to generate the pagination HTTP headers
	 */
	@GetMapping("/_search/news")
	@Timed
	public ResponseEntity<List<NewsDTO>> searchNews(@RequestParam String query, @ApiParam Pageable pageable)
			throws URISyntaxException {
		log.debug("REST request to search for a page of News for query {}", query);
		Page<News> page = newsSearchRepository.search(queryStringQuery(query), pageable);
		HttpHeaders headers = PaginationUtil.generateSearchPaginationHttpHeaders(query, page, "/api/_search/news");
		return new ResponseEntity<>(newsMapper.newsToNewsDTOs(page.getContent()), headers, HttpStatus.OK);
	}

	@RequestMapping(value = "/news", method = RequestMethod.PATCH, produces = MediaType.APPLICATION_JSON_VALUE)
	@Timed
	public ResponseEntity<Void> modifySimple(@RequestBody NewsDTO newsDTO) throws URISyntaxException {
		log.debug("REST request to update News : {}", newsDTO);
		newsService.verify(newsDTO);
		return ResponseEntity.ok().headers(HeaderUtil.createEntityUpdateAlert("news", newsDTO.getId().toString()))
				.build();

	}

}
