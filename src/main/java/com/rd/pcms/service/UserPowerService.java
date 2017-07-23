package com.rd.pcms.service;

import com.rd.pcms.service.dto.UserPowerDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * Service Interface for managing UserPower.
 */
public interface UserPowerService {

    /**
     * Save a userPower.
     *
     * @param userPowerDTO the entity to save
     * @return the persisted entity
     */
    UserPowerDTO save(UserPowerDTO userPowerDTO);

    /**
     *  Get all the userPowers.
     *  
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    Page<UserPowerDTO> findAll(Pageable pageable);

    /**
     *  Get the "id" userPower.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    UserPowerDTO findOne(Long id);

    /**
     *  Delete the "id" userPower.
     *
     *  @param id the id of the entity
     */
    void delete(Long id);
}
