package com.rd.pcms.repository;

import com.rd.pcms.domain.ProjectSpec;

import org.springframework.data.jpa.repository.*;

import java.util.List;

/**
 * Spring Data JPA repository for the ProjectSpec entity.
 */
@SuppressWarnings("unused")
public interface ProjectSpecRepository extends JpaRepository<ProjectSpec,Long> {

}
