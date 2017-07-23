package com.rd.pcms.service;

import com.rd.pcms.service.dto.ProjectMaterialDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * Service Interface for managing ProjectMaterial.
 */
public interface ProjectMaterialService {

    /**
     * Save a projectMaterial.
     *
     * @param projectMaterialDTO the entity to save
     * @return the persisted entity
     */
    ProjectMaterialDTO save(ProjectMaterialDTO projectMaterialDTO);

    /**
     *  Get all the projectMaterials.
     *  
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    Page<ProjectMaterialDTO> findAll(Pageable pageable);

    /**
     *  Get the "id" projectMaterial.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    ProjectMaterialDTO findOne(Long id);

    /**
     *  Delete the "id" projectMaterial.
     *
     *  @param id the id of the entity
     */
    void delete(Long id);
}
