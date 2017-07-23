package com.rd.pcms.repository;

import com.rd.pcms.domain.PpThickness;

import org.springframework.data.jpa.repository.*;

import java.util.List;

/**
 * Spring Data JPA repository for the PpThickness entity.
 */
@SuppressWarnings("unused")
public interface PpThicknessRepository extends JpaRepository<PpThickness,Long> {

}
