package com.jumore.zhxf.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jumore.zhxf.domain.Member;

/**
 * Spring Data JPA repository for the Member entity.
 */
public interface MemberRepository extends JpaRepository<Member, Long> {

	List<Member> findByWxNo(String wxno);

	Member findOneByWxNo(String wxNo);

}
