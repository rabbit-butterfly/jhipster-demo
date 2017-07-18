package com.rd.pcms.service;

import com.rd.pcms.service.dto.PpLineDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * Service Interface for managing PpLine.
 */
public interface PpLineService {

    /**
     * Save a ppLine.
     *
     * @param ppLineDTO the entity to save
     * @return the persisted entity
     */
    PpLineDTO save(PpLineDTO ppLineDTO);

    /**
     *  Get all the ppLines.
     *  
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    Page<PpLineDTO> findAll(Pageable pageable);

    /**
     *  Get the "id" ppLine.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    PpLineDTO findOne(Long id);

    /**
     *  Delete the "id" ppLine.
     *
     *  @param id the id of the entity
     */
    void delete(Long id);
}
