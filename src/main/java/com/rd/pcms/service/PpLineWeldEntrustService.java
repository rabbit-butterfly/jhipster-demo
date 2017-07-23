package com.rd.pcms.service;

import com.rd.pcms.service.dto.PpLineWeldEntrustDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * Service Interface for managing PpLineWeldEntrust.
 */
public interface PpLineWeldEntrustService {

    /**
     * Save a ppLineWeldEntrust.
     *
     * @param ppLineWeldEntrustDTO the entity to save
     * @return the persisted entity
     */
    PpLineWeldEntrustDTO save(PpLineWeldEntrustDTO ppLineWeldEntrustDTO);

    /**
     *  Get all the ppLineWeldEntrusts.
     *  
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    Page<PpLineWeldEntrustDTO> findAll(Pageable pageable);

    /**
     *  Get the "id" ppLineWeldEntrust.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    PpLineWeldEntrustDTO findOne(Long id);

    /**
     *  Delete the "id" ppLineWeldEntrust.
     *
     *  @param id the id of the entity
     */
    void delete(Long id);
}
