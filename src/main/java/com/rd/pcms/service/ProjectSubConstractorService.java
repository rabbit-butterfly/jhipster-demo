package com.rd.pcms.service;

import com.rd.pcms.service.dto.ProjectSubConstractorDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * Service Interface for managing ProjectSubConstractor.
 */
public interface ProjectSubConstractorService {

    /**
     * Save a projectSubConstractor.
     *
     * @param projectSubConstractorDTO the entity to save
     * @return the persisted entity
     */
    ProjectSubConstractorDTO save(ProjectSubConstractorDTO projectSubConstractorDTO);

    /**
     *  Get all the projectSubConstractors.
     *  
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    Page<ProjectSubConstractorDTO> findAll(Pageable pageable);

    /**
     *  Get the "id" projectSubConstractor.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    ProjectSubConstractorDTO findOne(Long id);

    /**
     *  Delete the "id" projectSubConstractor.
     *
     *  @param id the id of the entity
     */
    void delete(Long id);
}
