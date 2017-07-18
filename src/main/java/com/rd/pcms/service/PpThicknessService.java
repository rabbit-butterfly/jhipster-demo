package com.rd.pcms.service;

import com.rd.pcms.service.dto.PpThicknessDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * Service Interface for managing PpThickness.
 */
public interface PpThicknessService {

    /**
     * Save a ppThickness.
     *
     * @param ppThicknessDTO the entity to save
     * @return the persisted entity
     */
    PpThicknessDTO save(PpThicknessDTO ppThicknessDTO);

    /**
     *  Get all the ppThicknesses.
     *  
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    Page<PpThicknessDTO> findAll(Pageable pageable);

    /**
     *  Get the "id" ppThickness.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    PpThicknessDTO findOne(Long id);

    /**
     *  Delete the "id" ppThickness.
     *
     *  @param id the id of the entity
     */
    void delete(Long id);
}
