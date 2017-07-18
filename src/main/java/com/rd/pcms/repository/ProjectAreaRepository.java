package com.rd.pcms.repository;

import com.rd.pcms.domain.ProjectArea;

import org.springframework.data.jpa.repository.*;

import java.util.List;

/**
 * Spring Data JPA repository for the ProjectArea entity.
 */
@SuppressWarnings("unused")
public interface ProjectAreaRepository extends JpaRepository<ProjectArea,Long> {

}
