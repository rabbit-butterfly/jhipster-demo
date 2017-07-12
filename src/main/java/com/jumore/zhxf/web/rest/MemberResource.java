package com.jumore.zhxf.web.rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Optional;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codahale.metrics.annotation.Timed;
import com.jumore.zhxf.service.buddha.MemberService;
import com.jumore.zhxf.service.dto.MemberDTO;
import com.jumore.zhxf.web.rest.util.HeaderUtil;

/**
 * REST controller for managing Member.
 */
@RestController
@RequestMapping("/api/frong")
public class MemberResource {

	private final Logger log = LoggerFactory.getLogger(MemberResource.class);

	@Inject
	private MemberService memberService;

	/**
	 * POST /members : Create a new member.
	 *
	 * @param memberDTO
	 *            the memberDTO to create
	 * @return the ResponseEntity with status 201 (Created) and with body the
	 *         new memberDTO, or with status 400 (Bad Request) if the member has
	 *         already an ID
	 * @throws URISyntaxException
	 *             if the Location URI syntax is incorrect
	 */
	@PostMapping("/members")
	@Timed
	public ResponseEntity<MemberDTO> createMember(@RequestBody MemberDTO memberDTO) throws URISyntaxException {
		log.debug("REST request to save Member : {}", memberDTO);
		if (memberDTO.getId() != null) {
			return ResponseEntity.badRequest().headers(
					HeaderUtil.createFailureAlert("member", "idexists", "A new member cannot already have an ID"))
					.body(null);
		}
		MemberDTO result = memberService.save(memberDTO);
		return ResponseEntity.created(new URI("/api/members/" + result.getId()))
				.headers(HeaderUtil.createEntityCreationAlert("member", result.getId().toString())).body(result);
	}

	/**
	 * GET /members/:id : get the "id" member.
	 *
	 * @param id
	 *            the id of the memberDTO to retrieve
	 * @return the ResponseEntity with status 200 (OK) and with body the
	 *         memberDTO, or with status 404 (Not Found)
	 */
	@GetMapping("/members/{id}")
	@Timed
	public ResponseEntity<MemberDTO> getMember(@PathVariable Long id) {
		log.debug("REST request to get Member : {}", id);
		/// Member member = memberRepository.findOne(id);
		MemberDTO memberDTO = null;// memberMapper.memberToMemberDTO(member);
		return Optional.ofNullable(memberDTO).map(result -> new ResponseEntity<>(result, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

}
