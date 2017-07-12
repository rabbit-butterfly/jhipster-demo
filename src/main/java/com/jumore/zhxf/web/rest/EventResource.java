package com.jumore.zhxf.web.rest;

import static org.elasticsearch.index.query.QueryBuilders.queryStringQuery;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Example;
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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codahale.metrics.annotation.Timed;
import com.jumore.zhxf.domain.Event;
import com.jumore.zhxf.domain.Regist;
import com.jumore.zhxf.domain.ReportCount;
import com.jumore.zhxf.repository.EventRepository;
import com.jumore.zhxf.repository.RegistRepository;
import com.jumore.zhxf.repository.ReportCountRepository;
import com.jumore.zhxf.repository.search.EventSearchRepository;
import com.jumore.zhxf.service.buddha.EventService;
import com.jumore.zhxf.service.dto.EventDTO;
import com.jumore.zhxf.service.mapper.EventMapper;
import com.jumore.zhxf.web.rest.util.HeaderUtil;
import com.jumore.zhxf.web.rest.util.PaginationUtil;

import io.swagger.annotations.ApiParam;

/**
 * REST controller for managing Event.
 */
@RestController
@RequestMapping("/api")
public class EventResource {

	private final Logger log = LoggerFactory.getLogger(EventResource.class);

	@Inject
	private EventRepository eventRepository;

	@Inject
	private EventMapper eventMapper;

	@Inject
	private RegistRepository registRepository;

	@Inject
	private ReportCountRepository reportCountRepository;

	@Inject
	private EventSearchRepository eventSearchRepository;

	@Inject
	private EventService eventService;

	/**
	 * POST /events : Create a new event.
	 *
	 * @param eventDTO
	 *            the eventDTO to create
	 * @return the ResponseEntity with status 201 (Created) and with body the
	 *         new eventDTO, or with status 400 (Bad Request) if the event has
	 *         already an ID
	 * @throws URISyntaxException
	 *             if the Location URI syntax is incorrect	
	 */
	// @PostMapping("/events")
	@RequestMapping(value = "/events", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@Timed
	public ResponseEntity<EventDTO> createEvent(@RequestBody EventDTO eventDTO) throws URISyntaxException {
		log.debug("REST request to save Event : {}", eventDTO);
		
		if (eventRepository.countByTitleEquals(eventDTO.getTitle()) > 0) {
			return ResponseEntity.badRequest().headers(HeaderUtil.createFailureAlert("event.error", "event", "E-mail already in use")).body(null);
		}
		Event event = eventMapper.eventDTOToEvent(eventDTO);
		event.setCreatedTime(ZonedDateTime.now());
		
		event = eventRepository.save(event);
		EventDTO result = eventMapper.eventToEventDTO(event);
		eventSearchRepository.save(event);
		return ResponseEntity.created(new URI("/api/events/" + result.getId()))
				.headers(HeaderUtil.createEntityCreationAlert("event", result.getId().toString())).body(result);
	}

	/**
	 * PUT /events : Updates an existing event.
	 *
	 * @param eventDTO
	 *            the eventDTO to update
	 * @return the ResponseEntity with status 200 (OK) and with body the updated
	 *         eventDTO, or with status 400 (Bad Request) if the eventDTO is not
	 *         valid, or with status 500 (Internal Server Error) if the eventDTO
	 *         couldnt be updated
	 * @throws URISyntaxException
	 *             if the Location URI syntax is incorrect
	 */
	@PutMapping("/events")
	@Timed
	public ResponseEntity<EventDTO> updateEvent(@RequestBody EventDTO eventDTO) throws URISyntaxException {
		log.debug("REST request to update Event : {}", eventDTO);
		if (eventDTO.getId() == null) {
			return createEvent(eventDTO);
		}
		
		if (eventRepository.countByTitleEqualsAndIdIsNotIn(eventDTO.getTitle(),eventDTO.getId()) > 0) {
			return ResponseEntity.badRequest().headers(HeaderUtil.createFailureAlert("event.error", "event", "E-mail already in use")).body(null);
		}

		Event event = eventMapper.eventDTOToEvent(eventDTO);
		// event.setCreatedTime(ZonedDateTime.now());
		event = eventRepository.save(event);
		EventDTO result = eventMapper.eventToEventDTO(event);
		eventSearchRepository.save(event);
		return ResponseEntity.ok().headers(HeaderUtil.createEntityUpdateAlert("event", eventDTO.getId().toString()))
				.body(result);
	}

	/**
	 * GET /events : get all the events.
	 *
	 * @param pageable
	 *            the pagination information
	 * @return the ResponseEntity with status 200 (OK) and the list of events in
	 *         body
	 * @throws URISyntaxException
	 *             if there is an error to generate the pagination HTTP headers
	 */
	@GetMapping("/events")
	@Timed
	public ResponseEntity<List<EventDTO>> getAllEvents(@ApiParam Pageable pageable) throws URISyntaxException {
		log.debug("REST request to get a page of Events");

		Order[] orders = new Order[] { new Order(Direction.DESC, "createdTime") };

		PageRequest pageRequest = new PageRequest(pageable.getPageNumber(), pageable.getPageSize(), new Sort(orders));
		Page<Event> page = eventRepository.findAll(pageRequest);
		HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/events");
		return new ResponseEntity<>(eventMapper.eventsToEventDTOs(page.getContent()), headers, HttpStatus.OK);
		// return new ResponseEntity<>(page.getContent() ,headers,
		// HttpStatus.OK);
	}

	/**
	 * GET /events/:id : get the "id" event.
	 *
	 * @param id
	 *            the id of the eventDTO to retrieve
	 * @return the ResponseEntity with status 200 (OK) and with body the
	 *         eventDTO, or with status 404 (Not Found)
	 */
	@GetMapping("/events/{id}")
	@Timed
	public ResponseEntity<EventDTO> getEvent(@PathVariable Long id) {
		log.debug("REST request to get Event : {}", id);
		Event event = eventRepository.findOne(id);
		EventDTO eventDTO = eventMapper.eventToEventDTO(event);
		eventDTO.setPersonCount(registRepository.count(Example.of(new Regist(event.getId()))));
		// 完成总数
		eventDTO.setCompletedCount(reportCountRepository.count(Example.of(new ReportCount(event.getId()))));
		return Optional.ofNullable(eventDTO).map(result -> new ResponseEntity<>(result, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	/**
	 * DELETE /events/:id : delete the "id" event.
	 *
	 * @param id
	 *            the id of the eventDTO to delete
	 * @return the ResponseEntity with status 200 (OK)
	 */
	@DeleteMapping("/events/{id}")
	@Timed
	public ResponseEntity<Void> deleteEvent(@PathVariable Long id) {
		log.debug("REST request to delete Event : {}", id);
		eventRepository.delete(id);
		eventSearchRepository.delete(id);
		return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert("event", id.toString())).build();
	}

	/**
	 * SEARCH /_search/events?query=:query : search for the event corresponding
	 * to the query.
	 *
	 * @param query
	 *            the query of the event search
	 * @param pageable
	 *            the pagination information
	 * @return the result of the search
	 * @throws URISyntaxException
	 *             if there is an error to generate the pagination HTTP headers
	 */
	@GetMapping("/_search/events")
	@Timed
	public ResponseEntity<List<EventDTO>> searchEvents(@RequestParam String query, @ApiParam Pageable pageable)
			throws URISyntaxException {
		log.debug("REST request to search for a page of Events for query {}", query);
		Page<Event> page = eventSearchRepository.search(queryStringQuery(query), pageable);
		HttpHeaders headers = PaginationUtil.generateSearchPaginationHttpHeaders(query, page, "/api/_search/events");
		return new ResponseEntity<>(eventMapper.eventsToEventDTOs(page.getContent()), headers, HttpStatus.OK);
	}

	@RequestMapping(value = "/events", method = RequestMethod.PATCH, produces = MediaType.APPLICATION_JSON_VALUE)
	@Timed
	public ResponseEntity<Void> modifySimple(@RequestBody EventDTO eventDTO) throws URISyntaxException {
		log.debug("REST request to update WorkOvertime : {}", eventDTO);
		eventService.verify(eventDTO);
		return ResponseEntity.ok().headers(HeaderUtil.createEntityUpdateAlert("event", eventDTO.getId().toString()))
				.build();

	}

}
