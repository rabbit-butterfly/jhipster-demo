package com.jumore.zhxf.front.rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.ZonedDateTime;
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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codahale.metrics.annotation.Timed;
import com.jumore.zhxf.domain.Feedback;
import com.jumore.zhxf.repository.FeedbackRepository;
import com.jumore.zhxf.repository.search.FeedbackSearchRepository;
import com.jumore.zhxf.service.dto.EventDTO;
import com.jumore.zhxf.service.dto.FeedbackDTO;
import com.jumore.zhxf.service.mapper.FeedbackMapper;
import com.jumore.zhxf.web.rest.util.HeaderUtil;
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
public class FeedbackRest {

    private final Logger log = LoggerFactory.getLogger(FeedbackRest.class);
        
    @Inject
    private FeedbackRepository feedbackRepository;
    
    @Inject
    private FeedbackMapper feedbackMapper;


    /**
     * POST  /feedbacks : Create a new feedback.
     *
     * @param feedbackDTO the feedbackDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new feedbackDTO, or with status 400 (Bad Request) if the feedback has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/feedbacks")
    @Timed
    @ApiOperation(value="回向记录", notes="回向记录创建")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "feedbackDTO", value = "用户id",  paramType = "body", dataType = "FeedbackDTO")
    })
    public ResponseEntity<FeedbackDTO> createFeedback(@RequestBody FeedbackDTO feedbackDTO) throws URISyntaxException {
        log.debug("REST request to save Feedback : {}", feedbackDTO);
        if (feedbackDTO.getId() != null) {
            return ResponseEntity.badRequest().headers(HeaderUtil.createFailureAlert("feedback", "idexists", "A new feedback cannot already have an ID")).body(null);
        }
        Feedback feedback = feedbackMapper.feedbackDTOToFeedback(feedbackDTO);
        feedback.setCreatedTime(ZonedDateTime.now());
        feedback = feedbackRepository.save(feedback);
        FeedbackDTO result = feedbackMapper.feedbackToFeedbackDTO(feedback);
        feedbackRepository.save(feedback);
        return ResponseEntity.created(new URI("/api/feedbacks/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert("feedback", result.getId().toString()))
            .body(result);
    }
    /**
     * SEARCH  /_search/feedbacks?query=:query : search for the feedback corresponding
     * to the query.
     *
     * @param query the query of the feedback search 
     * @param pageable the pagination information
     * @return the result of the search
     * @throws URISyntaxException if there is an error to generate the pagination HTTP headers
     */
    @GetMapping("/_search/feedbacks")
    @Timed
    @ApiOperation(value="获取个人回向记录", notes="获取个人回向记录")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "query", value = "查询的条件(个人id)", paramType = "body", dataType = "String"),
        @ApiImplicitParam(name = "page",  value = "页数(page=0，表示第一页，从0开始算)", paramType = "body", dataType = "int"),
        @ApiImplicitParam(name = "size", value = "条数", paramType = "body", dataType = "int")
    })
    public ResponseEntity<List<FeedbackDTO>> searchFeedbacks(@RequestParam String query, @ApiParam Pageable pageable)
        throws URISyntaxException {
        log.debug("REST request to search for a page of Feedbacks for query {}", query);
        Order[] orders = new Order[] { new Order(Direction.DESC, "createdTime") };
		
		PageRequest pageRequest = new PageRequest(pageable.getPageNumber(), pageable.getPageSize()
				,new Sort(orders));
        Page<Feedback> page = feedbackRepository.findByUserId(Long.parseLong(query), pageRequest);
        HttpHeaders headers = PaginationUtil.generateSearchPaginationHttpHeaders(query, page, "/api/_search/feedbacks");
        return new ResponseEntity<>(feedbackMapper.feedbacksToFeedbackDTOs(page.getContent()), headers, HttpStatus.OK);
    }
}
