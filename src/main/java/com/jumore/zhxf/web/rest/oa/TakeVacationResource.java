package com.jumore.zhxf.web.rest.oa;


import java.net.URISyntaxException;
import java.util.Optional;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.codahale.metrics.annotation.Timed;

import com.jumore.zhxf.domain.oa.TakeVacation;
import com.jumore.zhxf.security.AuthoritiesConstants;
import com.jumore.zhxf.security.SecurityUtils;
import com.jumore.zhxf.service.oa.TakeVacationService;

/**
 * REST controller for managing users.
 *
 * <p>This class accesses the User entity, and needs to fetch its collection of authorities.</p>
 * <p>
 * For a normal use-case, it would be better to have an eager relationship between User and Authority,
 * and send everything to the client side: there would be no DTO, a lot less code, and an outer-join
 * which would be good for performance.
 * </p>
 * <p>
 * We use a DTO for 3 reasons:
 * <ul>
 * <li>We want to keep a lazy association between the user and the authorities, because people will
 * quite often do relationships with the user, and we don't want them to get the authorities all
 * the time for nothing (for performance reasons). This is the #1 goal: we should not impact our users'
 * application because of this use-case.</li>
 * <li> Not having an outer join causes n+1 requests to the database. This is not a real issue as
 * we have by default a second-level cache. This means on the first HTTP call we do the n+1 requests,
 * but then all authorities come from the cache, so in fact it's much better than doing an outer join
 * (which will get lots of data from the database, for each HTTP call).</li>
 * <li> As this manages users, for security reasons, we'd rather have a DTO layer.</li>
 * </p>
 * <p>Another option would be to have a specific JPA entity graph to handle this case.</p>
 */

@RestController
@RequestMapping("/api")
public class TakeVacationResource {

    private final Logger log = LoggerFactory.getLogger(TakeVacationResource.class);

    
    @Inject
	private TakeVacationService takeVacationService;
    /**
	 * GET /users -> get all users.
	 */
	@RequestMapping(value = "/takeVacation", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@Timed
	@Transactional(readOnly = true)
	@Secured(AuthoritiesConstants.USER)
	public ResponseEntity<TakeVacation> getAllTakeVacation(Pageable pageable)
			throws URISyntaxException {
		TakeVacation t=null;
		if (SecurityUtils.isCurrentUserInRole(AuthoritiesConstants.ADMIN)){
			t =takeVacationService.findAllOne();
		}else{
			t = takeVacationService.findOneByLogin(SecurityUtils.getCurrentUserLogin()); 
		}
		log.debug("{}",t);
		return Optional.ofNullable(t)
	                .map(takeVacation -> new ResponseEntity<>(takeVacation, HttpStatus.OK))
	                .orElse(new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR));
	}
	
}
