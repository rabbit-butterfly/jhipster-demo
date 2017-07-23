package com.rd.pcms.repository;

import com.rd.pcms.domain.PpLineDrawing;

import org.springframework.data.jpa.repository.*;

import java.util.List;

/**
 * Spring Data JPA repository for the PpLineDrawing entity.
 */
@SuppressWarnings("unused")
public interface PpLineDrawingRepository extends JpaRepository<PpLineDrawing,Long> {

}
