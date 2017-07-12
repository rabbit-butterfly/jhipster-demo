package com.jumore.zhxf.front.rest;

import java.net.URI;
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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codahale.metrics.annotation.Timed;
import com.jumore.zhxf.domain.ReportCount;
import com.jumore.zhxf.service.buddha.ReportCountService;
import com.jumore.zhxf.service.dto.ReportCountDTO;
import com.jumore.zhxf.service.dto.SimpleReportCountRes;
import com.jumore.zhxf.service.mapper.ReportCountMapper;
import com.jumore.zhxf.web.rest.util.HeaderUtil;
import com.jumore.zhxf.web.rest.util.PaginationUtil;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * REST controller for managing ReportCount.
 */
@RestController
@RequestMapping("/api/front")
public class ReportCountRest {

    private final Logger log = LoggerFactory.getLogger(ReportCountRest.class);
        
    
    
    @Inject
    private ReportCountService reportCountService;
    
    @Inject
    private ReportCountMapper reportCountMapper;


    /**
     * POST  /report-counts : Create a new reportCount.
     *
     * @param reportCountDTO the reportCountDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new reportCountDTO, or with status 400 (Bad Request) if the reportCount has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/report-counts")
    @Timed
    @ApiOperation(value="每日报数", notes="创建报数")
    public ResponseEntity<ReportCountDTO> createReportCount(@RequestBody ReportCountDTO dto) throws URISyntaxException {
        log.debug("REST request to save ReportCount : {}", dto);
        if (dto.getId() != null) {
           // return ResponseEntity.badRequest().headers(HeaderUtil.createFailureAlert("reportCount", "idexists", "A new reportCount cannot already have an ID")).body(null);
        }
        ReportCountDTO result= reportCountService.save(dto);
        return ResponseEntity.created(new URI("/api/report-counts/" + result.getId())).headers(HeaderUtil.createEntityCreationAlert("reportCount", result.getId().toString()))
            .body(result);
    }
    

    @GetMapping("/_search/report-counts")
    @Timed
    @ApiOperation(value="报数查询", notes="共修活动个人报数记录")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "eventId", value = "查询活动的Id",  paramType = "body",  required =true,dataType = "int"),
        @ApiImplicitParam(name = "userId", value = "用户ID", paramType = "body", required =true, dataType = "int"),
        @ApiImplicitParam(name = "page", value = "页数(page=0，表示第一页，从0开始算)",  dataType = "int"),
        @ApiImplicitParam(name = "size", value = "条数",  dataType = "int")
    })
    public ResponseEntity<List<ReportCountDTO>> searchReportCounts(@RequestParam Long eventId,@RequestParam Long userId, @ApiParam Pageable pageable)
        throws URISyntaxException {
        log.debug("REST request to search for a page of ReportCounts for query {}", eventId);
//        Page<ReportCount> page = reportCountSearchRepository.search(queryStringQuery(query), pageable);
        Order[] orders = new Order[] { new Order(Direction.DESC, "createdTime") };
		
		PageRequest pageRequest = new PageRequest(pageable.getPageNumber(), pageable.getPageSize()
				,new Sort(orders));
        Page<ReportCount> page = reportCountService.findByEventIdAndUserId(eventId,userId, pageRequest);
        HttpHeaders headers = PaginationUtil.generateSearchPaginationHttpHeaders(eventId.toString(), page, "/api/_search/report-counts");
        return new ResponseEntity<>(reportCountMapper.reportCountsToReportCountDTOs(page.getContent()), headers, HttpStatus.OK);
    }
   
  
    /**
     * GET  /feedbacks : get all the feedbacks.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of feedbacks in body
     * @throws URISyntaxException if there is an error to generate the pagination HTTP headers
     */
    //page.getContent().stream().map(user -> new ManagedUserDTO(user)).collect(Collectors.toList())
    @GetMapping("/feedbacks/danmu")
    @Timed
    @ApiOperation(value="获取最新回向弹幕300条", notes="获取最新回向弹幕300条 12小时内的")
    public ResponseEntity<List<SimpleReportCountRes>> getDanMu(@ApiParam Pageable pageable)
        throws URISyntaxException {
        log.debug("REST request to get a page of Feedbacks");
        List<SimpleReportCountRes> res= reportCountService.getDanMu(pageable);
        return new ResponseEntity<>(res ,HttpStatus.OK);
    }


}
