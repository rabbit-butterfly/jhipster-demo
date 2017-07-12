package com.jumore.zhxf.front.rest;

import java.net.URISyntaxException;
import java.time.ZonedDateTime;
import java.util.Optional;

import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codahale.metrics.annotation.Timed;
import com.jumore.zhxf.domain.Member;
import com.jumore.zhxf.repository.MemberRepository;
import com.jumore.zhxf.service.dto.MemberDTO;
import com.jumore.zhxf.service.mapper.MemberMapper;
import com.jumore.zhxf.web.rest.util.HeaderUtil;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * REST controller for managing Member.
 */
@RestController
@RequestMapping("/api/front")
public class MemberRest {

	private final Logger log = LoggerFactory.getLogger(MemberRest.class);

	@Inject
	private MemberRepository memberRepository;
	@Inject
	private MemberMapper memberMapper;
	/**
	 * PUT /members : Updates an existing member.
	 *
	 * @param memberDTO
	 *            the memberDTO to update
	 * @return the ResponseEntity with status 200 (OK) and with body the updated
	 *         memberDTO, or with status 400 (Bad Request) if the memberDTO is
	 *         not valid, or with status 500 (Internal Server Error) if the
	 *         memberDTO couldnt be updated
	 * @throws URISyntaxException
	 *             if the Location URI syntax is incorrect
	 */
	@PutMapping("/members")
	@Timed
	@ApiOperation(value = "个人信息", notes = "个人信息资料的修改")
	public ResponseEntity<MemberDTO> updateMember(@RequestBody MemberDTO memberDTO) throws URISyntaxException {
		log.debug("REST request to update Member : {}", memberDTO);

		Member member = memberRepository.findOneByWxNo(memberDTO.getWxNo());
		if (member == null) {
			return ResponseEntity.badRequest().headers(HeaderUtil.createFailureAlert("member", "source not exits", ""))
					.body(null);
		}

		// 7、保存资料时，需要检测必填项（姓名、法号/昵称、手机号码、姓名）

		if (StringUtils.isEmpty(memberDTO.getPersonName()) 
				|| StringUtils.isEmpty(memberDTO.getAlias())
				|| StringUtils.isEmpty(memberDTO.getPersonMobile())) {
			return ResponseEntity.badRequest().headers(HeaderUtil.createFailureAlert("member", "required param is null", ""))
					.body(null);
		}

		member.setPersonName(memberDTO.getPersonName());
		member.setPersonMobile(memberDTO.getPersonMobile());
		member.setAlias(memberDTO.getAlias());
		member.gender(memberDTO.getGender());
		member.setNature(memberDTO.getNature());
		member.setProvinceCode(memberDTO.getProvinceCode());
		member.setCityCode(memberDTO.getCityCode());
		member.setAddress(memberDTO.getAddress());
		member.setModifyTime(ZonedDateTime.now());

		member = memberRepository.save(member);
		MemberDTO result = memberDTO;
		return ResponseEntity.ok().headers(HeaderUtil.createEntityUpdateAlert("member", memberDTO.getWxNo()))
				.body(result);
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
	@ApiOperation(value = "获取个人信息", notes = "获取个人信息")
	@ApiImplicitParam(name = "id", value = "个人信息Id", paramType = "path", dataType = "long")
	public ResponseEntity<MemberDTO> getMember(@PathVariable Long id) {
		log.debug("REST request to get Member : {}", id);
		Member member = memberRepository.findOne(id);
		MemberDTO memberDTO = memberMapper.memberToMemberDTO(member);
		return Optional.ofNullable(memberDTO).map(result -> new ResponseEntity<>(result, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

}
