package com.rd.pcms.repository;

import com.rd.pcms.domain.ProjectUser;

import org.springframework.data.jpa.repository.*;

import java.util.List;

/**
 * Spring Data JPA repository for the ProjectUser entity.
 */
@SuppressWarnings("unused")
public interface ProjectUserRepository extends JpaRepository<ProjectUser,Long> {

}
