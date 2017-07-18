package com.rd.pcms.service;

import com.rd.pcms.service.dto.PpLineWeldCheckDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * Service Interface for managing PpLineWeldCheck.
 */
public interface PpLineWeldCheckService {

    /**
     * Save a ppLineWeldCheck.
     *
     * @param ppLineWeldCheckDTO the entity to save
     * @return the persisted entity
     */
    PpLineWeldCheckDTO save(PpLineWeldCheckDTO ppLineWeldCheckDTO);

    /**
     *  Get all the ppLineWeldChecks.
     *  
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    Page<PpLineWeldCheckDTO> findAll(Pageable pageable);

    /**
     *  Get the "id" ppLineWeldCheck.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    PpLineWeldCheckDTO findOne(Long id);

    /**
     *  Delete the "id" ppLineWeldCheck.
     *
     *  @param id the id of the entity
     */
    void delete(Long id);
}
