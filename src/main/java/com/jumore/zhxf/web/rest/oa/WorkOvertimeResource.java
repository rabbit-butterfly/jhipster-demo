package com.jumore.zhxf.web.rest.oa;

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

import com.jumore.zhxf.domain.oa.WorkOvertime;
import com.jumore.zhxf.repository.oa.WorkOvertimeRepository;
import com.jumore.zhxf.security.AuthoritiesConstants;
import com.jumore.zhxf.security.SecurityUtils;
import com.jumore.zhxf.service.oa.WorkOvertimeService;
import com.jumore.zhxf.web.rest.dto.oa.EOAConstantHelper.EStatus;
import com.jumore.zhxf.web.rest.dto.oa.WorkOvertimeDTO;
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
public class WorkOvertimeResource {

	private final Logger log = LoggerFactory.getLogger(WorkOvertimeResource.class);

	@Inject
	private WorkOvertimeService workOvertimeService;
	
	@Inject
	WorkOvertimeRepository workOvertimeRepository;
	
	@RequestMapping(value = "/workOvertime",
			method = RequestMethod.POST, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	@Timed
	public ResponseEntity<?> createWorkOvertime(@RequestBody WorkOvertimeDTO workOvertimeDTO,
			HttpServletRequest request) throws URISyntaxException {
		log.debug("REST request to save WorkOvertime : {}", workOvertimeDTO);
		return Optional.ofNullable(workOvertimeService.create(workOvertimeDTO))
				.map(user -> new ResponseEntity<String>(HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR));
	}
	
	/**
     * PUT  /users -> Updates an existing User.
     */
    @RequestMapping(value = "/workOvertime",
        method = RequestMethod.PUT,
        produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    @Transactional
    public ResponseEntity<WorkOvertime> updateWorkOvertimeById(@RequestBody WorkOvertimeDTO workOvertimeDTO) throws URISyntaxException {
        log.debug("REST request to update WorkOvertime : {}", workOvertimeDTO);
        
        
        WorkOvertime workOvertime =workOvertimeService.updateWorkOvertimeById(workOvertimeDTO) ;
        return ResponseEntity.ok()
                        .headers(HeaderUtil.createEntityUpdateAlert("workOvertime.updated", workOvertime.getId().toString()))
                        .body(workOvertime);
       
    }
    
	/**
     * GET  /workOvertime -> get all workOvertime.
     */
	@RequestMapping(value = "/workOvertime", 
			method = RequestMethod.GET, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	@Timed
	@Transactional(readOnly = true)
	public ResponseEntity<List<WorkOvertime>> getAllWorkOvertime(String createdBy,EStatus status,
			String startDate,String endDate,Pageable pageable) throws URISyntaxException {
		Order[] orders = new Order[]{       
			    new Order(Direction.DESC, "createdDate")
			};        
		PageRequest pageRequest = new PageRequest(pageable.getPageNumber(), pageable.getPageSize()
				,new Sort(orders));
					
		Page<WorkOvertime> page=null;
		if (SecurityUtils.isCurrentUserInRole(AuthoritiesConstants.ADMIN)){
			WorkOvertimeDTO dto = new WorkOvertimeDTO();
			dto.setCreatedBy(createdBy);
			dto.setStatus(status);
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			if(startDate != null && !startDate.equals("")){
				try {
					dto.setStartDate(format.parse(startDate));
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
			if(startDate != null && !startDate.equals("")){
				try {
					dto.setEndDate(format.parse(endDate));
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
			page = workOvertimeService.page(dto,pageRequest); 
		}else{
			page = workOvertimeService.findByCreatedBy(SecurityUtils.getCurrentUserLogin(), pageRequest); 
		}
		
		List<WorkOvertime> workOvertime = page.getContent();
		log.debug(" ");
		HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/workOvertime");
		return new ResponseEntity<>(workOvertime, headers, HttpStatus.OK);
	}
	
	/**
     * GET  /workOvertime/:id -> get the "id" workOvertime.
     */
    @RequestMapping(value = "/workOvertime/{id}",
        method = RequestMethod.GET,
        produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public ResponseEntity<WorkOvertime> getWorkOvertime(@PathVariable long id) {
        log.debug("REST request to get workOvertime : {}", id);
        return Optional.ofNullable(workOvertimeService.findWorkOvertimeById(id))
                .map(workOvertime -> new ResponseEntity<>(workOvertime, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR));
        
    }
    /**
     * DELETE  USER :login -> delete the "login" User.
     */
    @RequestMapping(value = "/workOvertime/{id}",
        method = RequestMethod.DELETE,
        produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public ResponseEntity<Void> deleteWorkOvertime(@PathVariable Long id) {
        log.debug("REST request to delete workOvertime: {}", id);
        workOvertimeService.deleteWorkOvertimeInformation(id);
        return ResponseEntity.ok().headers(HeaderUtil.createAlert( "user-management.deleted", id.toString())).build();
    }
	

    /**
     * PUT  /users -> Updates an existing User.
     */
    @RequestMapping(value = "/workOvertime",
        method = RequestMethod.PATCH,
        produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    @Transactional
    @Secured(AuthoritiesConstants.ADMIN)
    public ResponseEntity<Void> modifySimple(@RequestBody WorkOvertimeDTO workOvertimeDTO) throws URISyntaxException {
        log.debug("REST request to update WorkOvertime : {}", workOvertimeDTO);
        workOvertimeService.verify(workOvertimeDTO) ;
        return ResponseEntity.ok()
                        .headers(HeaderUtil.createEntityUpdateAlert("workOvertime.updated", workOvertimeDTO.getId().toString()))
                        .build();
        
    }

}
