package com.jumore.zhxf.repository.oa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jumore.zhxf.domain.oa.CheckConfig;

/**
 * Spring Data JPA repository for the CheckConfig entity.
 */
public interface CheckConfigRepository extends JpaRepository<CheckConfig, Long> {
	
	List<CheckConfig> findByStatus (Integer status);


}
