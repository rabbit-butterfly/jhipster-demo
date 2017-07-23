package com.rd.pcms.service;

import com.rd.pcms.service.dto.PpLineWeldDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * Service Interface for managing PpLineWeld.
 */
public interface PpLineWeldService {

    /**
     * Save a ppLineWeld.
     *
     * @param ppLineWeldDTO the entity to save
     * @return the persisted entity
     */
    PpLineWeldDTO save(PpLineWeldDTO ppLineWeldDTO);

    /**
     *  Get all the ppLineWelds.
     *  
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    Page<PpLineWeldDTO> findAll(Pageable pageable);

    /**
     *  Get the "id" ppLineWeld.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    PpLineWeldDTO findOne(Long id);

    /**
     *  Delete the "id" ppLineWeld.
     *
     *  @param id the id of the entity
     */
    void delete(Long id);
}
