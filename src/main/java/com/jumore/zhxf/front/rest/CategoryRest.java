package com.jumore.zhxf.front.rest;

import java.net.URISyntaxException;
import java.util.List;

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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codahale.metrics.annotation.Timed;
import com.jumore.zhxf.domain.Category;
import com.jumore.zhxf.service.buddha.CategoryService;
import com.jumore.zhxf.service.dto.CategoryDTO;
import com.jumore.zhxf.service.mapper.CategoryMapper;
import com.jumore.zhxf.web.rest.util.PaginationUtil;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * REST controller for managing Category.
 */
@RestController
@RequestMapping("/api/front")
public class CategoryRest {

    private final Logger log = LoggerFactory.getLogger(CategoryRest.class);
    
    @Inject
    private CategoryMapper categoryMapper;

    @Inject
    private CategoryService categoryService;

    /**
     * SEARCH  /_search/categories?query=:query : search for the category corresponding
     * to the query.
     *
     * @param query the query of the category search 
     * @param pageable the pagination information
     * @return the result of the search
     * @throws URISyntaxException if there is an error to generate the pagination HTTP headers
     */
    @GetMapping("/categories/{parentId}")
    @Timed
    @ApiOperation(value="获取类目", notes="查询一级类目或二级类目")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "query", value = "查询的条件(0：所有一级类目，否则则表示查询该一级类目下的所有三级二级类目)",  dataType = "Long"),
        @ApiImplicitParam(name = "page", value = "页数(page=0，表示第一页，从0开始算)",  dataType = "int"),
        @ApiImplicitParam(name = "size", value = "条数",  dataType = "int")
    })
    public ResponseEntity<List<CategoryDTO>> searchCategories(@PathVariable Long parentId, @ApiParam Pageable pageable)
        throws URISyntaxException {
        log.debug("REST request to search for a page of Categories for parentId {}", parentId);
        Order[] orders = new Order[] { new Order(Direction.ASC, "id") };
		
		PageRequest pageRequest = new PageRequest(pageable.getPageNumber(), pageable.getPageSize()
				,new Sort(orders));
        Page<Category> page = categoryService.getCategoryByParentIdAndStatus(parentId,1, pageRequest);
        HttpHeaders headers = PaginationUtil.generateSearchPaginationHttpHeaders(parentId.toString(), page, "/api/categories/{query}");
        return new ResponseEntity<>(categoryMapper.categoriesToCategoryDTOs(page.getContent()), headers, HttpStatus.OK);
    }
    
}
