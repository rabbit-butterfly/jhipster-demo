package com.rd.pcms.service.impl;

import com.rd.pcms.service.BizAuthService;
import com.rd.pcms.domain.BizAuth;
import com.rd.pcms.repository.BizAuthRepository;
import com.rd.pcms.service.dto.BizAuthDTO;
import com.rd.pcms.service.mapper.BizAuthMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * Service Implementation for managing BizAuth.
 */
@Service
@Transactional
public class BizAuthServiceImpl implements BizAuthService{

    private final Logger log = LoggerFactory.getLogger(BizAuthServiceImpl.class);
    
    private final BizAuthRepository bizAuthRepository;

    private final BizAuthMapper bizAuthMapper;

    public BizAuthServiceImpl(BizAuthRepository bizAuthRepository, BizAuthMapper bizAuthMapper) {
        this.bizAuthRepository = bizAuthRepository;
        this.bizAuthMapper = bizAuthMapper;
    }

    /**
     * Save a bizAuth.
     *
     * @param bizAuthDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public BizAuthDTO save(BizAuthDTO bizAuthDTO) {
        log.debug("Request to save BizAuth : {}", bizAuthDTO);
        BizAuth bizAuth = bizAuthMapper.toEntity(bizAuthDTO);
        bizAuth = bizAuthRepository.save(bizAuth);
        BizAuthDTO result = bizAuthMapper.toDto(bizAuth);
        return result;
    }

    /**
     *  Get all the bizAuths.
     *  
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<BizAuthDTO> findAll(Pageable pageable) {
        log.debug("Request to get all BizAuths");
        Page<BizAuth> result = bizAuthRepository.findAll(pageable);
        return result.map(bizAuth -> bizAuthMapper.toDto(bizAuth));
    }


    /**
     *  get all the bizAuths where Role is null.
     *  @return the list of entities
     */
    @Transactional(readOnly = true) 
    public List<BizAuthDTO> findAllWhereRoleIsNull() {
        log.debug("Request to get all bizAuths where Role is null");
        return StreamSupport
            .stream(bizAuthRepository.findAll().spliterator(), false)
            .filter(bizAuth -> bizAuth.getRole() == null)
            .map(bizAuthMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }

    /**
     *  Get one bizAuth by id.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public BizAuthDTO findOne(Long id) {
        log.debug("Request to get BizAuth : {}", id);
        BizAuth bizAuth = bizAuthRepository.findOne(id);
        BizAuthDTO bizAuthDTO = bizAuthMapper.toDto(bizAuth);
        return bizAuthDTO;
    }

    /**
     *  Delete the  bizAuth by id.
     *
     *  @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete BizAuth : {}", id);
        bizAuthRepository.delete(id);
    }
}
