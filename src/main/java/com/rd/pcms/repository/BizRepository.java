package com.rd.pcms.repository;

import com.rd.pcms.domain.Biz;

import org.springframework.data.jpa.repository.*;

import java.util.List;

/**
 * Spring Data JPA repository for the Biz entity.
 */
@SuppressWarnings("unused")
public interface BizRepository extends JpaRepository<Biz,Long> {

}