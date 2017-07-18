package com.rd.pcms.service;

import com.rd.pcms.service.dto.ProjectUserDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * Service Interface for managing ProjectUser.
 */
public interface ProjectUserService {

    /**
     * Save a projectUser.
     *
     * @param projectUserDTO the entity to save
     * @return the persisted entity
     */
    ProjectUserDTO save(ProjectUserDTO projectUserDTO);

    /**
     *  Get all the projectUsers.
     *  
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    Page<ProjectUserDTO> findAll(Pageable pageable);

    /**
     *  Get the "id" projectUser.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    ProjectUserDTO findOne(Long id);

    /**
     *  Delete the "id" projectUser.
     *
     *  @param id the id of the entity
     */
    void delete(Long id);
}
