package com.rd.pcms.repository;

import com.rd.pcms.domain.ProjectWelder;

import org.springframework.data.jpa.repository.*;

import java.util.List;

/**
 * Spring Data JPA repository for the ProjectWelder entity.
 */
@SuppressWarnings("unused")
public interface ProjectWelderRepository extends JpaRepository<ProjectWelder,Long> {

}
