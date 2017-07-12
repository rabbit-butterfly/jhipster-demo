package com.jumore.zhxf.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.jumore.zhxf.domain.Feedback;
import com.jumore.zhxf.domain.Member;
import com.jumore.zhxf.repository.FeedbackRepository;
import com.jumore.zhxf.repository.MemberRepository;
import com.jumore.zhxf.repository.search.FeedbackSearchRepository;
import com.jumore.zhxf.web.rest.util.HeaderUtil;
import com.jumore.zhxf.web.rest.util.PaginationUtil;
import com.jumore.zhxf.service.dto.FeedbackDTO;
import com.jumore.zhxf.service.mapper.FeedbackMapper;

import io.swagger.annotations.ApiParam;
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
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import static org.elasticsearch.index.query.QueryBuilders.*;

/**
 * REST controller for managing Feedback.
 */
@RestController
@RequestMapping("/api")
public class FeedbackResource {

    private final Logger log = LoggerFactory.getLogger(FeedbackResource.class);
        
    @Inject
    private FeedbackRepository feedbackRepository;
    
    @Inject
    private MemberRepository memberRepository;
    
    @Inject
    private FeedbackMapper feedbackMapper;

    @Inject
    private FeedbackSearchRepository feedbackSearchRepository;

    /**
     * POST  /feedbacks : Create a new feedback.
     *
     * @param feedbackDTO the feedbackDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new feedbackDTO, or with status 400 (Bad Request) if the feedback has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/feedbacks")
    @Timed
    public ResponseEntity<FeedbackDTO> createFeedback(@RequestBody FeedbackDTO feedbackDTO) throws URISyntaxException {
        log.debug("REST request to save Feedback : {}", feedbackDTO);
        if (feedbackDTO.getId() != null) {
            return ResponseEntity.badRequest().headers(HeaderUtil.createFailureAlert("feedback", "idexists", "A new feedback cannot already have an ID")).body(null);
        }
        Feedback feedback = feedbackMapper.feedbackDTOToFeedback(feedbackDTO);
        feedback = feedbackRepository.save(feedback);
        FeedbackDTO result = feedbackMapper.feedbackToFeedbackDTO(feedback);
        feedbackSearchRepository.save(feedback);
        return ResponseEntity.created(new URI("/api/feedbacks/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert("feedback", result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /feedbacks : Updates an existing feedback.
     *
     * @param feedbackDTO the feedbackDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated feedbackDTO,
     * or with status 400 (Bad Request) if the feedbackDTO is not valid,
     * or with status 500 (Internal Server Error) if the feedbackDTO couldnt be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/feedbacks")
    @Timed
    public ResponseEntity<FeedbackDTO> updateFeedback(@RequestBody FeedbackDTO feedbackDTO) throws URISyntaxException {
        log.debug("REST request to update Feedback : {}", feedbackDTO);
        if (feedbackDTO.getId() == null) {
            return createFeedback(feedbackDTO);
        }
        Feedback feedback = feedbackMapper.feedbackDTOToFeedback(feedbackDTO);
        feedback = feedbackRepository.save(feedback);
        FeedbackDTO result = feedbackMapper.feedbackToFeedbackDTO(feedback);
        feedbackSearchRepository.save(feedback);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert("feedback", feedbackDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /feedbacks : get all the feedbacks.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of feedbacks in body
     * @throws URISyntaxException if there is an error to generate the pagination HTTP headers
     */
    //page.getContent().stream().map(user -> new ManagedUserDTO(user)).collect(Collectors.toList())
    @GetMapping("/feedbacks")
    @Timed
    public ResponseEntity<List<FeedbackDTO>> getAllFeedbacks(@ApiParam Pageable pageable)
        throws URISyntaxException {
        log.debug("REST request to get a page of Feedbacks");
        Order[] orders = new Order[] { new Order(Direction.DESC, "createdTime") };
		
		PageRequest pageRequest = new PageRequest(pageable.getPageNumber(), pageable.getPageSize()
				,new Sort(orders));
        Page<Feedback> page = feedbackRepository.findAll(pageRequest);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/feedbacks");
        List<FeedbackDTO> feedbackDTOList = feedbackMapper.feedbacksToFeedbackDTOs(page.getContent());
        for(FeedbackDTO feedbackDTO : feedbackDTOList){
        	Member member = memberRepository.findOne(feedbackDTO.getUserId());
        	feedbackDTO.setWxNo(member.getWxNo());
        	feedbackDTO.setPersonName(member.getPersonName());
        	feedbackDTO.setPersonMobile(member.getPersonMobile());
        }
        return new ResponseEntity<>(feedbackDTOList
                , headers, HttpStatus.OK);
    }

    /**
     * GET  /feedbacks/:id : get the "id" feedback.
     *
     * @param id the id of the feedbackDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the feedbackDTO, or with status 404 (Not Found)
     */
    @GetMapping("/feedbacks/{id}")
    @Timed
    public ResponseEntity<FeedbackDTO> getFeedback(@PathVariable Long id) {
        log.debug("REST request to get Feedback : {}", id);
        Feedback feedback = feedbackRepository.findOne(id);
        FeedbackDTO feedbackDTO = feedbackMapper.feedbackToFeedbackDTO(feedback);
        return Optional.ofNullable(feedbackDTO)
            .map(result -> new ResponseEntity<>(
                result,
                HttpStatus.OK))
            .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * DELETE  /feedbacks/:id : delete the "id" feedback.
     *
     * @param id the id of the feedbackDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/feedbacks/{id}")
    @Timed
    public ResponseEntity<Void> deleteFeedback(@PathVariable Long id) {
        log.debug("REST request to delete Feedback : {}", id);
        feedbackRepository.delete(id);
        feedbackSearchRepository.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert("feedback", id.toString())).build();
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
    public ResponseEntity<List<FeedbackDTO>> searchFeedbacks(@RequestParam String query, @ApiParam Pageable pageable)
        throws URISyntaxException {
        log.debug("REST request to search for a page of Feedbacks for query {}", query);
        Page<Feedback> page = feedbackSearchRepository.search(queryStringQuery(query), pageable);
        HttpHeaders headers = PaginationUtil.generateSearchPaginationHttpHeaders(query, page, "/api/_search/feedbacks");
        return new ResponseEntity<>(feedbackMapper.feedbacksToFeedbackDTOs(page.getContent()), headers, HttpStatus.OK);
    }


}
