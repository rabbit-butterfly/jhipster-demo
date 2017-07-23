package com.rd.pcms.repository;

import com.rd.pcms.domain.PpLine;

import org.springframework.data.jpa.repository.*;

import java.util.List;

/**
 * Spring Data JPA repository for the PpLine entity.
 */
@SuppressWarnings("unused")
public interface PpLineRepository extends JpaRepository<PpLine,Long> {

}
