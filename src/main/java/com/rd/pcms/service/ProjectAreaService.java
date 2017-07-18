package com.rd.pcms.service;

import com.rd.pcms.service.dto.ProjectAreaDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * Service Interface for managing ProjectArea.
 */
public interface ProjectAreaService {

    /**
     * Save a projectArea.
     *
     * @param projectAreaDTO the entity to save
     * @return the persisted entity
     */
    ProjectAreaDTO save(ProjectAreaDTO projectAreaDTO);

    /**
     *  Get all the projectAreas.
     *  
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    Page<ProjectAreaDTO> findAll(Pageable pageable);

    /**
     *  Get the "id" projectArea.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    ProjectAreaDTO findOne(Long id);

    /**
     *  Delete the "id" projectArea.
     *
     *  @param id the id of the entity
     */
    void delete(Long id);
}
