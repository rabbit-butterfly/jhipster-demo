package com.rd.pcms.repository;

import com.rd.pcms.domain.ProjectSubConstractor;

import org.springframework.data.jpa.repository.*;

import java.util.List;

/**
 * Spring Data JPA repository for the ProjectSubConstractor entity.
 */
@SuppressWarnings("unused")
public interface ProjectSubConstractorRepository extends JpaRepository<ProjectSubConstractor,Long> {

}
