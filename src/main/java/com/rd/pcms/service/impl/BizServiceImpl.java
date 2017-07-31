package com.rd.pcms.service.impl;

import com.rd.pcms.service.BizService;
import com.rd.pcms.domain.Biz;
import com.rd.pcms.repository.BizRepository;
import com.rd.pcms.service.dto.BizDTO;
import com.rd.pcms.service.mapper.BizMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Service Implementation for managing Biz.
 */
@Service
@Transactional
public class BizServiceImpl implements BizService{

    private final Logger log = LoggerFactory.getLogger(BizServiceImpl.class);
    
    private final BizRepository bizRepository;

    private final BizMapper bizMapper;

    public BizServiceImpl(BizRepository bizRepository, BizMapper bizMapper) {
        this.bizRepository = bizRepository;
        this.bizMapper = bizMapper;
    }

    /**
     * Save a biz.
     *
     * @param bizDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public BizDTO save(BizDTO bizDTO) {
        log.debug("Request to save Biz : {}", bizDTO);
        Biz biz = bizMapper.toEntity(bizDTO);
        biz = bizRepository.save(biz);
        BizDTO result = bizMapper.toDto(biz);
        return result;
    }

    /**
     *  Get all the bizs.
     *  
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<BizDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Bizs");
        Page<Biz> result = bizRepository.findAll(pageable);
        return result.map(biz -> bizMapper.toDto(biz));
    }

    /**
     *  Get one biz by id.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public BizDTO findOne(Long id) {
        log.debug("Request to get Biz : {}", id);
        Biz biz = bizRepository.findOne(id);
        BizDTO bizDTO = bizMapper.toDto(biz);
        return bizDTO;
    }

    /**
     *  Delete the  biz by id.
     *
     *  @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Biz : {}", id);
        bizRepository.delete(id);
    }
}
