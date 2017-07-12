package com.jumore.zhxf.web.rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codahale.metrics.annotation.Timed;
import com.jumore.zhxf.domain.Category;
import com.jumore.zhxf.repository.CategoryRepository;
import com.jumore.zhxf.repository.search.CategorySearchRepository;
import com.jumore.zhxf.service.buddha.CategoryService;
import com.jumore.zhxf.service.dto.CategoryDTO;
import com.jumore.zhxf.service.mapper.CategoryMapper;
import com.jumore.zhxf.web.rest.util.HeaderUtil;
import com.jumore.zhxf.web.rest.util.PaginationUtil;

import io.swagger.annotations.ApiParam;

/**
 * REST controller for managing Category.
 */
@RestController
@RequestMapping("/api")
public class CategoryResource {

    private final Logger log = LoggerFactory.getLogger(CategoryResource.class);
        
    @Inject
    private CategoryRepository categoryRepository;

    @Inject
    private CategorySearchRepository categorySearchRepository;
    
    @Inject
    private CategoryService categoryService;
    
    @Inject
    private CategoryMapper categoryMapper;

    /**
     * POST  /categories : Create a new category.
     *
     * @param categoryDTO the categoryDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new categoryDTO, or with status 400 (Bad Request) if the category has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/categories")
    @Timed
    public ResponseEntity<CategoryDTO> createCategory(@RequestBody CategoryDTO categoryDTO) throws URISyntaxException {
        log.debug("REST request to save Category : {}", categoryDTO);
        if (categoryDTO.getId() != null) {
            return ResponseEntity.badRequest().headers(HeaderUtil.createFailureAlert("category", "idexists", "A new category cannot already have an ID")).body(null);
        }
        Category category = categoryMapper.categoryDTOToCategory(categoryDTO);
        if(category.getParentId() == null){
        	category.setParentId(0L);
        }
        category.setCreatedTime(ZonedDateTime.now());
        category.setModifyTime(ZonedDateTime.now());
        category = categoryRepository.save(category);
        CategoryDTO result = categoryMapper.categoryToCategoryDTO(category);        
        categorySearchRepository.save(category);
        return ResponseEntity.created(new URI("/api/categories/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert("category", result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /categories : Updates an existing category.
     *
     * @param categoryDTO the categoryDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated categoryDTO,
     * or with status 400 (Bad Request) if the categoryDTO is not valid,
     * or with status 500 (Internal Server Error) if the categoryDTO couldnt be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/categories")
    @Timed
    public ResponseEntity<CategoryDTO> updateCategory(@RequestBody CategoryDTO categoryDTO) throws URISyntaxException {
        log.debug("REST request to update Category : {}", categoryDTO);
        if (categoryDTO.getId() == null) {
            return createCategory(categoryDTO);
        }
        Category category = categoryMapper.categoryDTOToCategory(categoryDTO);
        category = categoryRepository.save(category);
        CategoryDTO result = categoryMapper.categoryToCategoryDTO(category);
        categorySearchRepository.save(category);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert("category", categoryDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /categories : get all the categories.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of categories in body
     * @throws URISyntaxException if there is an error to generate the pagination HTTP headers
     */
    @GetMapping("/categories")
    @Timed
    public ResponseEntity<List<CategoryDTO>> getAllCategories(@ApiParam Pageable pageable)
        throws URISyntaxException {
        log.debug("REST request to get a page of Categories");
        Order[] orders = new Order[] { new Order(Direction.DESC, "createdTime") };
		
		PageRequest pageRequest = new PageRequest(pageable.getPageNumber(), pageable.getPageSize()
				,new Sort(orders));
        Page<Category> page = categoryRepository.findAll(pageRequest);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/categories");
        return new ResponseEntity<>(categoryMapper.categoriesToCategoryDTOs(page.getContent()), headers, HttpStatus.OK);
    }

    /**
     * GET  /categories/:id : get the "id" category.
     *
     * @param id the id of the categoryDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the categoryDTO, or with status 404 (Not Found)
     */
    @GetMapping("/categories/{id}")
    @Timed
    public ResponseEntity<CategoryDTO> getCategory(@PathVariable Long id) {
        log.debug("REST request to get Category : {}", id);
        Category category = categoryRepository.findOne(id);
        CategoryDTO categoryDTO = categoryMapper.categoryToCategoryDTO(category);
        return Optional.ofNullable(categoryDTO)
            .map(result -> new ResponseEntity<>(
                result,
                HttpStatus.OK))
            .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * DELETE  /categories/:id : delete the "id" category.
     *
     * @param id the id of the categoryDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/categories/{id}")
    @Timed
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
        log.debug("REST request to delete Category : {}", id);
        categoryRepository.delete(id);
        categorySearchRepository.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert("category", id.toString())).build();
    }

    /**
     * SEARCH  /_search/categories?query=:query : search for the category corresponding
     * to the query.
     *
     * @param query the query of the category search 
     * @param pageable the pagination information
     * @return the result of the search
     * @throws URISyntaxException if there is an error to generate the pagination HTTP headers
     */
    @GetMapping("/_search/categories")
    @Timed
    public ResponseEntity<List<CategoryDTO>> searchCategories(@RequestParam String query, @ApiParam Pageable pageable)
        throws URISyntaxException {
        log.debug("REST request to search for a page of Categories for query {}", query);
        Order[] orders = new Order[] { new Order(Direction.DESC, "createdTime") };
		
		PageRequest pageRequest = new PageRequest(pageable.getPageNumber(), pageable.getPageSize()
				,new Sort(orders));
        Page<Category> page = categoryService.getCategoryByParentId(Long.parseLong(query), pageRequest);
        HttpHeaders headers = PaginationUtil.generateSearchPaginationHttpHeaders(query, page, "/api/_search/categories");
        return new ResponseEntity<>(categoryMapper.categoriesToCategoryDTOs(page.getContent()), headers, HttpStatus.OK);
    }

    

}
