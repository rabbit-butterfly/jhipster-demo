package com.rd.pcms.service;

import com.rd.pcms.service.dto.UserAreaDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * Service Interface for managing UserArea.
 */
public interface UserAreaService {

    /**
     * Save a userArea.
     *
     * @param userAreaDTO the entity to save
     * @return the persisted entity
     */
    UserAreaDTO save(UserAreaDTO userAreaDTO);

    /**
     *  Get all the userAreas.
     *  
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    Page<UserAreaDTO> findAll(Pageable pageable);

    /**
     *  Get the "id" userArea.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    UserAreaDTO findOne(Long id);

    /**
     *  Delete the "id" userArea.
     *
     *  @param id the id of the entity
     */
    void delete(Long id);
}
