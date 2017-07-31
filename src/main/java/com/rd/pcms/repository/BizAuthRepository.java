package com.rd.pcms.repository;

import com.rd.pcms.domain.BizAuth;

import org.springframework.data.jpa.repository.*;

import java.util.List;

/**
 * Spring Data JPA repository for the BizAuth entity.
 */
@SuppressWarnings("unused")
public interface BizAuthRepository extends JpaRepository<BizAuth,Long> {

}
