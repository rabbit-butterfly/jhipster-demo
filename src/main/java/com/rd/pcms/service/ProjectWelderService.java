package com.rd.pcms.service;

import com.rd.pcms.service.dto.ProjectWelderDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * Service Interface for managing ProjectWelder.
 */
public interface ProjectWelderService {

    /**
     * Save a projectWelder.
     *
     * @param projectWelderDTO the entity to save
     * @return the persisted entity
     */
    ProjectWelderDTO save(ProjectWelderDTO projectWelderDTO);

    /**
     *  Get all the projectWelders.
     *  
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    Page<ProjectWelderDTO> findAll(Pageable pageable);

    /**
     *  Get the "id" projectWelder.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    ProjectWelderDTO findOne(Long id);

    /**
     *  Delete the "id" projectWelder.
     *
     *  @param id the id of the entity
     */
    void delete(Long id);
}
