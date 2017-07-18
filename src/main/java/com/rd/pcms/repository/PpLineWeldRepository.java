package com.rd.pcms.repository;

import com.rd.pcms.domain.PpLineWeld;

import org.springframework.data.jpa.repository.*;

import java.util.List;

/**
 * Spring Data JPA repository for the PpLineWeld entity.
 */
@SuppressWarnings("unused")
public interface PpLineWeldRepository extends JpaRepository<PpLineWeld,Long> {

}
