package com.jumore.zhxf.repository;

import com.jumore.zhxf.domain.Regist;
import com.jumore.zhxf.domain.oa.CheckConfig;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Spring Data JPA repository for the Regist entity.
 */
@SuppressWarnings("unused")
public interface RegistRepository extends JpaRepository<Regist,Long> {
	Page<Regist> findByEventId (Long eventId,Pageable pageable);
	
	long countByUserIdEqualsAndEventIdEquals(Long UserId ,Long EventId);
}
