package com.rd.pcms.service;

import com.rd.pcms.service.dto.PpLineDrawingDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * Service Interface for managing PpLineDrawing.
 */
public interface PpLineDrawingService {

    /**
     * Save a ppLineDrawing.
     *
     * @param ppLineDrawingDTO the entity to save
     * @return the persisted entity
     */
    PpLineDrawingDTO save(PpLineDrawingDTO ppLineDrawingDTO);

    /**
     *  Get all the ppLineDrawings.
     *  
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    Page<PpLineDrawingDTO> findAll(Pageable pageable);

    /**
     *  Get the "id" ppLineDrawing.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    PpLineDrawingDTO findOne(Long id);

    /**
     *  Delete the "id" ppLineDrawing.
     *
     *  @param id the id of the entity
     */
    void delete(Long id);
}
