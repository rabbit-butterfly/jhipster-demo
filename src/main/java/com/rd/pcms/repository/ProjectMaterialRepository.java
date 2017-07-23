package com.rd.pcms.repository;

import com.rd.pcms.domain.ProjectMaterial;

import org.springframework.data.jpa.repository.*;

import java.util.List;

/**
 * Spring Data JPA repository for the ProjectMaterial entity.
 */
@SuppressWarnings("unused")
public interface ProjectMaterialRepository extends JpaRepository<ProjectMaterial,Long> {

}
