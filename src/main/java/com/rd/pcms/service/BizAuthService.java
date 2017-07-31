package com.rd.pcms.service;

import com.rd.pcms.service.dto.BizAuthDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * Service Interface for managing BizAuth.
 */
public interface BizAuthService {

    /**
     * Save a bizAuth.
     *
     * @param bizAuthDTO the entity to save
     * @return the persisted entity
     */
    BizAuthDTO save(BizAuthDTO bizAuthDTO);

    /**
     *  Get all the bizAuths.
     *  
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    Page<BizAuthDTO> findAll(Pageable pageable);
    /**
     *  Get all the BizAuthDTO where Role is null.
     *
     *  @return the list of entities
     */
    List<BizAuthDTO> findAllWhereRoleIsNull();

    /**
     *  Get the "id" bizAuth.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    BizAuthDTO findOne(Long id);

    /**
     *  Delete the "id" bizAuth.
     *
     *  @param id the id of the entity
     */
    void delete(Long id);
}
