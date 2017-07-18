package com.rd.pcms.repository;

import com.rd.pcms.domain.PpLineWeldMaterial;

import org.springframework.data.jpa.repository.*;

import java.util.List;

/**
 * Spring Data JPA repository for the PpLineWeldMaterial entity.
 */
@SuppressWarnings("unused")
public interface PpLineWeldMaterialRepository extends JpaRepository<PpLineWeldMaterial,Long> {

}
