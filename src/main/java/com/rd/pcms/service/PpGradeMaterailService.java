package com.rd.pcms.service;

import com.rd.pcms.service.dto.PpGradeMaterailDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * Service Interface for managing PpGradeMaterail.
 */
public interface PpGradeMaterailService {

    /**
     * Save a ppGradeMaterail.
     *
     * @param ppGradeMaterailDTO the entity to save
     * @return the persisted entity
     */
    PpGradeMaterailDTO save(PpGradeMaterailDTO ppGradeMaterailDTO);

    /**
     *  Get all the ppGradeMaterails.
     *  
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    Page<PpGradeMaterailDTO> findAll(Pageable pageable);

    /**
     *  Get the "id" ppGradeMaterail.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    PpGradeMaterailDTO findOne(Long id);

    /**
     *  Delete the "id" ppGradeMaterail.
     *
     *  @param id the id of the entity
     */
    void delete(Long id);
}
