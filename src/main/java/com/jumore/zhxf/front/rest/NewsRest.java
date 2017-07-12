package com.jumore.zhxf.front.rest;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URISyntaxException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;

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
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codahale.metrics.annotation.Timed;
import com.jumore.zhxf.config.AppSystemProperties;
import com.jumore.zhxf.domain.News;
import com.jumore.zhxf.service.buddha.NewsService;
import com.jumore.zhxf.service.dto.NewsDTO;
import com.jumore.zhxf.service.mapper.NewsMapper;
import com.jumore.zhxf.web.rest.util.PaginationUtil;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * REST controller for managing News.
 */
@RestController
@RequestMapping("/api/front")
public class NewsRest {

	private final Logger log = LoggerFactory.getLogger(NewsRest.class);

	@Inject
	private NewsService newsService;

	@Inject
	private NewsMapper newsMapper;

	@Autowired
	private AppSystemProperties appSystemProperties;

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
	@ApiOperation(value = "资讯内容获取", notes = "通过一级类目找到具体的资讯")
	@ApiImplicitParams({ @ApiImplicitParam(name = "categoryId", value = "查询的条件", dataType = "String"),
			@ApiImplicitParam(name = "page", value = "页数(page=0，表示第一页，从0开始算)", dataType = "int"),
			@ApiImplicitParam(name = "size", value = "条数", dataType = "int") })

	public ResponseEntity<List<NewsDTO>> getAllNews(Long categoryId, @ApiParam Pageable pageable)
			throws URISyntaxException {
		log.debug("REST request to get a page of News");
		Order[] orders = new Order[] { new Order(Direction.DESC, "createdTime") };

		PageRequest pageRequest = new PageRequest(pageable.getPageNumber(), pageable.getPageSize(), new Sort(orders));
		Page<News> page = newsService.findByCategoryId(categoryId, pageRequest);
		HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/news");

		return new ResponseEntity<>(newsMapper.newsToNewsDTOs(page.getContent()), headers, HttpStatus.OK);
	}

	@GetMapping("/news/image/{imageName}")
	@Timed
	@ApiOperation(value = "获取资讯图片", notes = "通过文件名获取图片")
	public void getImage(HttpServletResponse response, @PathVariable("imageName") String imageName)
			throws URISyntaxException {
		try {

			response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
			response.addHeader("Cache-Control", "post-check=0, pre-check=0");
			response.setHeader("Pragma", "no-cache");
			response.setContentType("image/jpeg");

			String filePath = appSystemProperties.getRoot() + File.separator + imageName;

			OutputStream os = response.getOutputStream();
			BufferedOutputStream bos = new BufferedOutputStream(os);

			InputStream is = null;

			is = new FileInputStream(filePath);
			BufferedInputStream bis = new BufferedInputStream(is);

			int length = 0;
			byte[] temp = new byte[1 * 1024 * 10];

			while ((length = bis.read(temp)) != -1) {
				bos.write(temp, 0, length);
			}
			bos.flush();
			bis.close();
			bos.close();
			is.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
