package com.rd.pcms.service;

import com.rd.pcms.service.dto.PpIinspectionTatioDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * Service Interface for managing PpIinspectionTatio.
 */
public interface PpIinspectionTatioService {

    /**
     * Save a ppIinspectionTatio.
     *
     * @param ppIinspectionTatioDTO the entity to save
     * @return the persisted entity
     */
    PpIinspectionTatioDTO save(PpIinspectionTatioDTO ppIinspectionTatioDTO);

    /**
     *  Get all the ppIinspectionTatios.
     *  
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    Page<PpIinspectionTatioDTO> findAll(Pageable pageable);

    /**
     *  Get the "id" ppIinspectionTatio.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    PpIinspectionTatioDTO findOne(Long id);

    /**
     *  Delete the "id" ppIinspectionTatio.
     *
     *  @param id the id of the entity
     */
    void delete(Long id);
}
