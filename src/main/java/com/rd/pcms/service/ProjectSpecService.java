package com.rd.pcms.service;

import com.rd.pcms.service.dto.ProjectSpecDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * Service Interface for managing ProjectSpec.
 */
public interface ProjectSpecService {

    /**
     * Save a projectSpec.
     *
     * @param projectSpecDTO the entity to save
     * @return the persisted entity
     */
    ProjectSpecDTO save(ProjectSpecDTO projectSpecDTO);

    /**
     *  Get all the projectSpecs.
     *  
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    Page<ProjectSpecDTO> findAll(Pageable pageable);

    /**
     *  Get the "id" projectSpec.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    ProjectSpecDTO findOne(Long id);

    /**
     *  Delete the "id" projectSpec.
     *
     *  @param id the id of the entity
     */
    void delete(Long id);
}
