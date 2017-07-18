package com.rd.pcms.service;

import com.rd.pcms.service.dto.WelderDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * Service Interface for managing Welder.
 */
public interface WelderService {

    /**
     * Save a welder.
     *
     * @param welderDTO the entity to save
     * @return the persisted entity
     */
    WelderDTO save(WelderDTO welderDTO);

    /**
     *  Get all the welders.
     *  
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    Page<WelderDTO> findAll(Pageable pageable);

    /**
     *  Get the "id" welder.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    WelderDTO findOne(Long id);

    /**
     *  Delete the "id" welder.
     *
     *  @param id the id of the entity
     */
    void delete(Long id);
}
