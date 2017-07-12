package com.jumore.zhxf.service.buddha;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jumore.zhxf.domain.Member;
import com.jumore.zhxf.repository.MemberRepository;
import com.jumore.zhxf.service.dto.MemberDTO;
import com.jumore.zhxf.service.mapper.MemberMapper;

@Service
@Transactional
public class MemberService {
	//private final Logger log = LoggerFactory.getLogger(RegistService.class);
	@Inject
	private MemberRepository memberRepository;

	@Inject
	private MemberMapper memberMapper;

	public MemberDTO save(MemberDTO memberDTO) {
		Member member = memberMapper.memberDTOToMember(memberDTO);
		memberRepository.save(member);

		MemberDTO res = memberMapper.memberToMemberDTO(member);
		return res;
	}

}
