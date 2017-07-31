package com.rd.pcms.service;

import com.rd.pcms.service.dto.BizDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * Service Interface for managing Biz.
 */
public interface BizService {

    /**
     * Save a biz.
     *
     * @param bizDTO the entity to save
     * @return the persisted entity
     */
    BizDTO save(BizDTO bizDTO);

    /**
     *  Get all the bizs.
     *  
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    Page<BizDTO> findAll(Pageable pageable);

    /**
     *  Get the "id" biz.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    BizDTO findOne(Long id);

    /**
     *  Delete the "id" biz.
     *
     *  @param id the id of the entity
     */
    void delete(Long id);
}
