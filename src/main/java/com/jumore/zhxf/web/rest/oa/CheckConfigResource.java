package com.jumore.zhxf.web.rest.oa;


import java.net.URI;
import java.net.URISyntaxException;
import java.util.Optional;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.codahale.metrics.annotation.Timed;

import com.jumore.zhxf.domain.oa.CheckConfig;
import com.jumore.zhxf.security.AuthoritiesConstants;
import com.jumore.zhxf.service.oa.CheckConfigService;
import com.jumore.zhxf.web.rest.dto.oa.CheckConfigDTO;
import com.jumore.zhxf.web.rest.util.HeaderUtil;

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
public class CheckConfigResource {

	private final Logger log = LoggerFactory.getLogger(CheckConfigResource.class);

	@Inject
//	private TakeVacationDetailService takeVacationDetailService;
	private CheckConfigService checkConfigService;


	/**
	 * POST /users -> Creates a new user.
	 * <p>
	 * Creates a new user if the login and email are not already used, and sends
	 * an mail with an activation link. The user needs to be activated on
	 * creation.
	 * </p>
	 */
	@RequestMapping(value = "/checkConfig", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@Timed
	@Secured(AuthoritiesConstants.USER)
	public ResponseEntity<?> createCheckConfig(@RequestBody CheckConfigDTO checkConfigDTO,
			HttpServletRequest request) throws URISyntaxException {
		log.debug("REST request to save checkConfigDTO : {}", checkConfigDTO);
		CheckConfig checkConfig =checkConfigService.create(checkConfigDTO);
//		return new ResponseEntity<>(checkConfig, HttpStatus.OK);
		String baseUrl = request.getScheme() + // "http"
				"://" + // "://"
				request.getServerName() + // "myhost"
				":" + // ":"
				request.getServerPort() + // "80"
				request.getContextPath();
		return ResponseEntity.created(new URI("/api/checkConfig/" + checkConfig.getUserId()))
				.headers(HeaderUtil.createAlert("oa-takeVacationDetail.created", checkConfig.getUserId().toString()))
				.body(checkConfig);
	}

	/**
	 * PUT /users -> Updates an existing User.
	 */
	@RequestMapping(value = "/checkConfig", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	@Timed
	@Transactional
	@Secured(AuthoritiesConstants.USER)
	public ResponseEntity<CheckConfig> updateCheckConfig(
			@RequestBody CheckConfigDTO checkConfigDTO) throws URISyntaxException {
		log.debug("REST request to update CheckConfig : {}", checkConfigDTO);
		CheckConfig checkConfig = checkConfigService.modify(checkConfigDTO);
		return ResponseEntity.ok()
				.headers(HeaderUtil.createAlert("oa-takeVacationDetail.updated", checkConfig.getUserId().toString()))
				.body(checkConfig);

	}

	
	/**
	 * GET /users/:login -> get the "login" user.
	 */
	@RequestMapping(value = "/checkConfig", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@Timed
	@Secured(AuthoritiesConstants.USER)
	public ResponseEntity<CheckConfigDTO> getCheckConfig() {
		log.debug("REST request to get CheckConfig : {}");
		CheckConfigDTO checkConfig=checkConfigService.findCheckConfig();
		return new ResponseEntity<>(checkConfig, HttpStatus.OK);
	}

	
}
