package com.rd.pcms.repository;

import com.rd.pcms.domain.PpLineWeldCheck;

import org.springframework.data.jpa.repository.*;

import java.util.List;

/**
 * Spring Data JPA repository for the PpLineWeldCheck entity.
 */
@SuppressWarnings("unused")
public interface PpLineWeldCheckRepository extends JpaRepository<PpLineWeldCheck,Long> {

}
