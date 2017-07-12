package com.jumore.zhxf.front.rest;

import java.net.URISyntaxException;
import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codahale.metrics.annotation.Timed;
import com.jumore.zhxf.service.buddha.EventService;
import com.jumore.zhxf.service.dto.EventDTO;
import com.jumore.zhxf.service.dto.SimpleEventRes;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

/**
 * REST controller for managing Regist.
 */
@RestController
@RequestMapping("/api/front")
public class EventRest {

	private final Logger log = LoggerFactory.getLogger(EventRest.class);

	@Inject
	private EventService eventService;

	/**
	 * GET /regists : get all the regists.
	 *
	 * @param pageable
	 *            the pagination information
	 * @return the ResponseEntity with status 200 (OK) and the list of regists
	 *         in body
	 * @throws URISyntaxException
	 *             if there is an error to generate the pagination HTTP headers
	 */
	@ApiOperation(value = "获取活动列表", notes = "获取首页活动列表",hidden=false)
	@GetMapping("/events")
	@Timed
	public ResponseEntity<List<EventDTO>> findOnGoing() throws URISyntaxException {
		log.debug("REST request to get a page of Regists");
		List<EventDTO> list = eventService.findOnGoing();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@GetMapping("/events/regist/{userId}")
	@Timed
	@ApiOperation(value = "获取可报名的活动表列", notes = "获取可报名的活动表列", response = SimpleEventRes.class, responseContainer = "List")
	@ApiImplicitParam(name = "userId", value = "用户ID", paramType = "path", required = true, dataType = "Long")
	public ResponseEntity<List<SimpleEventRes>> getEventAbleRegistByUserId(@PathVariable Long userId) {
		log.debug("REST request to get Regist : {}", userId);
		// Regist regist = registRepository.findOne(id);
		List<SimpleEventRes> result = eventService.selectEventAbleRegistByUserId(userId);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	@GetMapping("/events/reportCount/{userId}")
	@Timed
	@ApiOperation(value = "获取可报数所活有动列表(已报名未结束的)", notes = "获取可报数所有活动列表(已报名未结束的)")
	@ApiImplicitParam(name = "userId", value = "用户ID", paramType = "path", required = true, dataType = "Long")
	public ResponseEntity<List<SimpleEventRes>> getEventAbleReportCountByUserId(@PathVariable Long userId) {
		log.debug("REST request to get Regist : {}", userId);
		List<SimpleEventRes> result = eventService.selectEventAbleReportCountByUserId(userId);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	
	@GetMapping("/events/{userId}")
	@Timed
	@ApiOperation(value = "获取我的功课列表", notes = "获取我的功课列表", response = SimpleEventRes.class, responseContainer = "List")
	@ApiImplicitParam(name = "userId", value = "用户ID", paramType = "path", required = true, dataType = "Long")
	public ResponseEntity<List<EventDTO>> findEvnts(@PathVariable Long userId) throws URISyntaxException {
		log.debug("REST request to get a page of Regists");
		List<EventDTO> list = eventService.selectByUserId(userId);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	
}
