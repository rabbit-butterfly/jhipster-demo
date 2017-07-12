package com.jumore.zhxf.web.rest.oa;


import java.net.URI;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

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
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.codahale.metrics.annotation.Timed;

import com.jumore.zhxf.domain.oa.TakeVacationDetail;
import com.jumore.zhxf.security.AuthoritiesConstants;
import com.jumore.zhxf.security.SecurityUtils;
import com.jumore.zhxf.service.oa.TakeVacationDetailService;
import com.jumore.zhxf.web.rest.dto.oa.TakeVacationDetailDTO;
import com.jumore.zhxf.web.rest.util.HeaderUtil;
import com.jumore.zhxf.web.rest.util.PaginationUtil;

/**
 * REST controller for managing users.
 *
 * <p>
 * This class accesses the User entity, and needs to fetch its collection of
 * authorities.
 * </p>
 * <p>
 * For a normal use-case, it would be better to have an eager relationship
 * between User and Authority, and send everything to the client side: there
 * would be no DTO, a lot less code, and an outer-join which would be good for
 * performance.
 * </p>
 * <p>
 * We use a DTO for 3 reasons:
 * <ul>
 * <li>We want to keep a lazy association between the user and the authorities,
 * because people will quite often do relationships with the user, and we don't
 * want them to get the authorities all the time for nothing (for performance
 * reasons). This is the #1 goal: we should not impact our users' application
 * because of this use-case.</li>
 * <li>Not having an outer join causes n+1 requests to the database. This is not
 * a real issue as we have by default a second-level cache. This means on the
 * first HTTP call we do the n+1 requests, but then all authorities come from
 * the cache, so in fact it's much better than doing an outer join (which will
 * get lots of data from the database, for each HTTP call).</li>
 * <li>As this manages users, for security reasons, we'd rather have a DTO
 * layer.</li>
 * </p>
 * <p>
 * Another option would be to have a specific JPA entity graph to handle this
 * case.
 * </p>
 */

@RestController
@RequestMapping("/api")
public class TakeVacationDetailResource {

	private final Logger log = LoggerFactory.getLogger(TakeVacationDetailResource.class);

	@Inject
	private TakeVacationDetailService takeVacationDetailService;


	/**
	 * POST /users -> Creates a new user.
	 * <p>
	 * Creates a new user if the login and email are not already used, and sends
	 * an mail with an activation link. The user needs to be activated on
	 * creation.
	 * </p>
	 */
	@RequestMapping(value = "/takeVacationDetail", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@Timed
	@Secured(AuthoritiesConstants.USER)
	public ResponseEntity<?> createTakeVacationDetail(@RequestBody TakeVacationDetailDTO takeVacationDetailDTO,
			HttpServletRequest request) throws URISyntaxException {
		log.debug("REST request to save takeVacationDetail : {}", takeVacationDetailDTO);
		TakeVacationDetail takeVacationDetail = takeVacationDetailService.create(takeVacationDetailDTO);
		String baseUrl = request.getScheme() + // "http"
				"://" + // "://"
				request.getServerName() + // "myhost"
				":" + // ":"
				request.getServerPort() + // "80"
				request.getContextPath();

		return ResponseEntity.created(new URI("/api/workOvertime/" + takeVacationDetail.getId()))
				.headers(HeaderUtil.createAlert("oa-takeVacationDetail.created", takeVacationDetail.getId().toString()))
				.body(takeVacationDetail);
	}

	/**
	 * PUT /users -> Updates an existing User.
	 */
	@RequestMapping(value = "/takeVacationDetail", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	@Timed
	@Transactional
	@Secured(AuthoritiesConstants.USER)
	public ResponseEntity<TakeVacationDetail> updateTakeVacationDetail(
			@RequestBody TakeVacationDetailDTO takeVacationDetailDTO) throws URISyntaxException {
		log.debug("REST request to update TakeVacationDetail : {}", takeVacationDetailDTO);

		TakeVacationDetail takeVacationDetail = takeVacationDetailService
				.updateTakeVacationDetailById(takeVacationDetailDTO);

		return ResponseEntity.ok()
				.headers(HeaderUtil.createAlert("oa-takeVacationDetail.updated", takeVacationDetail.getId().toString()))
				.body(takeVacationDetail);

	}

	/**
	 * GET /users -> get all users.
	 */
	@RequestMapping(value = "/takeVacationDetail", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@Timed
	@Transactional(readOnly = true)
	@Secured(AuthoritiesConstants.USER)
	public ResponseEntity<List<TakeVacationDetail>> getAllTakeVacationDetail(String createdBy,Integer status,
			String startDate,String endDate,Pageable pageable)
			throws URISyntaxException {
		Order[] orders = new Order[]{       
			    new Order(Direction.DESC, "createdDate")
			};        
		PageRequest pageRequest = new PageRequest(pageable.getPageNumber(), pageable.getPageSize()
				,new Sort(orders));
					
		Page<TakeVacationDetail> page=null;
		if (SecurityUtils.isCurrentUserInRole(AuthoritiesConstants.ADMIN)){
			TakeVacationDetail takeVacationDetail = new TakeVacationDetail(); 
			takeVacationDetail.setCreatedBy(createdBy);
			takeVacationDetail.setStatus(status);
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			if(startDate != null && !startDate.equals("")){
				try {
					takeVacationDetail.setStartDate(format.parse(startDate));
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
			if(startDate != null && !startDate.equals("")){
				try {
					takeVacationDetail.setEndDate(format.parse(endDate));
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
			page = takeVacationDetailService.page(takeVacationDetail, pageRequest);
		}else{
			page = takeVacationDetailService.findByCreatedBy(SecurityUtils.getCurrentUserLogin(), pageRequest); 
		}
		
		List<TakeVacationDetail> takeVacationDetail = page.getContent();
		log.debug(" ");
		HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/workOvertime");
		return new ResponseEntity<>(takeVacationDetail, headers, HttpStatus.OK);
	}
	/**
	 * GET /users/:login -> get the "login" user.
	 */
	@RequestMapping(value = "/takeVacationDetail/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@Timed
	@Secured(AuthoritiesConstants.USER)
	public ResponseEntity<TakeVacationDetail> getTakeVacationDetail(@PathVariable long id) {
		log.debug("REST request to get TakeVacationDetail : {}", id);
		return Optional.ofNullable(takeVacationDetailService.findTakeVacationDetailById(id))
				.map(takeVacationDetail -> new ResponseEntity<>(takeVacationDetail, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR));

	}

	/**
	 * DELETE USER :login -> delete the "login" User.
	 */

	@RequestMapping(value = "/takeVacationDetail/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	@Timed
	@Secured(AuthoritiesConstants.USER)
	public ResponseEntity<Void> deleteTakeVacationDetail(@PathVariable Long id) {
		log.debug("REST request to delete TakeVacationDetail: {}", id);
		takeVacationDetailService.deleteTakeVacationDetail(id);
		return ResponseEntity.ok()
				.headers(HeaderUtil.createEntityDeletionAlert("oa-takeVacationDetail.deleted", id.toString())).build();
	}

	/**
	 * PATCH takeVacationDetail :id -> update one attir the "id"	 * takeVacationDetail.
	 */

	@RequestMapping(value = "/takeVacationDetail", method = RequestMethod.PATCH, produces = MediaType.APPLICATION_JSON_VALUE)
	@Timed
	@Secured(AuthoritiesConstants.ADMIN)
	public ResponseEntity<Void> modifySimple(@RequestBody TakeVacationDetailDTO takeVacationDetailDTO) {
		log.debug("REST request to delete TakeVacationDetail: {}", takeVacationDetailDTO);
		try {
			takeVacationDetailService.verify(takeVacationDetailDTO.getId(), takeVacationDetailDTO);
			
			return ResponseEntity.ok()
					.headers(HeaderUtil.createEntityUpdateAlert("oa-takeVacationDetail.patch", takeVacationDetailDTO.getId().toString())).build();
		} catch (RuntimeException e) {
			
			return ResponseEntity.ok()
					.headers(HeaderUtil.createAlert("oa-takeVacationDetail.patchError", e.getMessage())).build();
		}
	}
	
}
