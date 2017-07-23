package com.rd.pcms.service;

import com.rd.pcms.service.dto.PpLineWeldMaterialDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * Service Interface for managing PpLineWeldMaterial.
 */
public interface PpLineWeldMaterialService {

    /**
     * Save a ppLineWeldMaterial.
     *
     * @param ppLineWeldMaterialDTO the entity to save
     * @return the persisted entity
     */
    PpLineWeldMaterialDTO save(PpLineWeldMaterialDTO ppLineWeldMaterialDTO);

    /**
     *  Get all the ppLineWeldMaterials.
     *  
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    Page<PpLineWeldMaterialDTO> findAll(Pageable pageable);

    /**
     *  Get the "id" ppLineWeldMaterial.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    PpLineWeldMaterialDTO findOne(Long id);

    /**
     *  Delete the "id" ppLineWeldMaterial.
     *
     *  @param id the id of the entity
     */
    void delete(Long id);
}
