package com.jumore.zhxf.web.rest;

import java.net.URI;
import java.net.URISyntaxException;
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
import com.jumore.zhxf.domain.ReportCount;
import com.jumore.zhxf.repository.ReportCountRepository;
import com.jumore.zhxf.repository.search.ReportCountSearchRepository;
import com.jumore.zhxf.service.buddha.ReportCountService;
import com.jumore.zhxf.service.dto.ReportCountDTO;
import com.jumore.zhxf.service.mapper.ReportCountMapper;
import com.jumore.zhxf.web.rest.util.HeaderUtil;
import com.jumore.zhxf.web.rest.util.PaginationUtil;

import io.swagger.annotations.ApiParam;

/**
 * REST controller for managing ReportCount.
 */
@RestController
@RequestMapping("/api")
public class ReportCountResource {

    private final Logger log = LoggerFactory.getLogger(ReportCountResource.class);
        
    @Inject
    private ReportCountRepository reportCountRepository;

    @Inject
    private ReportCountMapper reportCountMapper;
    @Inject
    private ReportCountService reportCountService;
    @Inject
    private ReportCountSearchRepository reportCountSearchRepository;

    /**
     * POST  /report-counts : Create a new reportCount.
     *
     * @param reportCountDTO the reportCountDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new reportCountDTO, or with status 400 (Bad Request) if the reportCount has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/report-counts")
    @Timed
    public ResponseEntity<ReportCountDTO> createReportCount(@RequestBody ReportCountDTO reportCountDTO) throws URISyntaxException {
        log.debug("REST request to save ReportCount : {}", reportCountDTO);
        if (reportCountDTO.getId() != null) {
            return ResponseEntity.badRequest().headers(HeaderUtil.createFailureAlert("reportCount", "idexists", "A new reportCount cannot already have an ID")).body(null);
        }
        ReportCount reportCount = reportCountMapper.reportCountDTOToReportCount(reportCountDTO);
        reportCount = reportCountRepository.save(reportCount);
        ReportCountDTO result = reportCountMapper.reportCountToReportCountDTO(reportCount);
        reportCountSearchRepository.save(reportCount);
        return ResponseEntity.created(new URI("/api/report-counts/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert("reportCount", result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /report-counts : Updates an existing reportCount.
     *
     * @param reportCountDTO the reportCountDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated reportCountDTO,
     * or with status 400 (Bad Request) if the reportCountDTO is not valid,
     * or with status 500 (Internal Server Error) if the reportCountDTO couldnt be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/report-counts")
    @Timed
    public ResponseEntity<ReportCountDTO> updateReportCount(@RequestBody ReportCountDTO reportCountDTO) throws URISyntaxException {
        log.debug("REST request to update ReportCount : {}", reportCountDTO);
        if (reportCountDTO.getId() == null) {
            return createReportCount(reportCountDTO);
        }
        ReportCount reportCount = reportCountMapper.reportCountDTOToReportCount(reportCountDTO);
        reportCount = reportCountRepository.save(reportCount);
        ReportCountDTO result = reportCountMapper.reportCountToReportCountDTO(reportCount);
        reportCountSearchRepository.save(reportCount);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert("reportCount", reportCountDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /report-counts : get all the reportCounts.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of reportCounts in body
     * @throws URISyntaxException if there is an error to generate the pagination HTTP headers
     */
    @GetMapping("/report-counts")
    @Timed
    public ResponseEntity<List<ReportCountDTO>> getAllReportCounts(@ApiParam Pageable pageable)
        throws URISyntaxException {
        log.debug("REST request to get a page of ReportCounts");
        Order[] orders = new Order[] { new Order(Direction.DESC, "createdTime") };
		
		PageRequest pageRequest = new PageRequest(pageable.getPageNumber(), pageable.getPageSize()
				,new Sort(orders));
        Page<ReportCount> page = reportCountRepository.findAll(pageRequest);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/report-counts");
        return new ResponseEntity<>(reportCountMapper.reportCountsToReportCountDTOs(page.getContent()), headers, HttpStatus.OK);
    }

    /**
     * GET  /report-counts/:id : get the "id" reportCount.
     *
     * @param id the id of the reportCountDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the reportCountDTO, or with status 404 (Not Found)
     */
    @GetMapping("/report-counts/{id}")
    @Timed
    public ResponseEntity<ReportCountDTO> getReportCount(@PathVariable Long id) {
        log.debug("REST request to get ReportCount : {}", id);
        ReportCount reportCount = reportCountRepository.findOne(id);
        ReportCountDTO reportCountDTO = reportCountMapper.reportCountToReportCountDTO(reportCount);
        return Optional.ofNullable(reportCountDTO)
            .map(result -> new ResponseEntity<>(
                result,
                HttpStatus.OK))
            .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * DELETE  /report-counts/:id : delete the "id" reportCount.
     *
     * @param id the id of the reportCountDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/report-counts/{id}")
    @Timed
    public ResponseEntity<Void> deleteReportCount(@PathVariable Long id) {
        log.debug("REST request to delete ReportCount : {}", id);
        reportCountRepository.delete(id);
        reportCountSearchRepository.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert("reportCount", id.toString())).build();
    }

    /**
     * SEARCH  /_search/report-counts?query=:query : search for the reportCount corresponding
     * to the query.
     *
     * @param query the query of the reportCount search 
     * @param pageable the pagination information
     * @return the result of the search
     * @throws URISyntaxException if there is an error to generate the pagination HTTP headers
     */
    @GetMapping("/_search/report-counts")
    @Timed
    public ResponseEntity<List<ReportCountDTO>> searchReportCounts(@RequestParam String query, @ApiParam Pageable pageable)
        throws URISyntaxException {
        log.debug("REST request to search for a page of ReportCounts for query {}", query);
//        Page<ReportCount> page = reportCountSearchRepository.search(queryStringQuery(query), pageable);
        Page<ReportCount> page = reportCountService.findByEventId(Long.parseLong(query), pageable);
        HttpHeaders headers = PaginationUtil.generateSearchPaginationHttpHeaders(query, page, "/api/_search/report-counts");
        return new ResponseEntity<>(reportCountMapper.reportCountsToReportCountDTOs(page.getContent()), headers, HttpStatus.OK);
    }


}
