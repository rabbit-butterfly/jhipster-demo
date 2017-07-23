package com.rd.pcms.service.impl;

import com.rd.pcms.service.PpLineWeldCheckService;
import com.rd.pcms.domain.PpLineWeldCheck;
import com.rd.pcms.repository.PpLineWeldCheckRepository;
import com.rd.pcms.service.dto.PpLineWeldCheckDTO;
import com.rd.pcms.service.mapper.PpLineWeldCheckMapper;
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
 * Service Implementation for managing PpLineWeldCheck.
 */
@Service
@Transactional
public class PpLineWeldCheckServiceImpl implements PpLineWeldCheckService{

    private final Logger log = LoggerFactory.getLogger(PpLineWeldCheckServiceImpl.class);
    
    private final PpLineWeldCheckRepository ppLineWeldCheckRepository;

    private final PpLineWeldCheckMapper ppLineWeldCheckMapper;

    public PpLineWeldCheckServiceImpl(PpLineWeldCheckRepository ppLineWeldCheckRepository, PpLineWeldCheckMapper ppLineWeldCheckMapper) {
        this.ppLineWeldCheckRepository = ppLineWeldCheckRepository;
        this.ppLineWeldCheckMapper = ppLineWeldCheckMapper;
    }

    /**
     * Save a ppLineWeldCheck.
     *
     * @param ppLineWeldCheckDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public PpLineWeldCheckDTO save(PpLineWeldCheckDTO ppLineWeldCheckDTO) {
        log.debug("Request to save PpLineWeldCheck : {}", ppLineWeldCheckDTO);
        PpLineWeldCheck ppLineWeldCheck = ppLineWeldCheckMapper.toEntity(ppLineWeldCheckDTO);
        ppLineWeldCheck = ppLineWeldCheckRepository.save(ppLineWeldCheck);
        PpLineWeldCheckDTO result = ppLineWeldCheckMapper.toDto(ppLineWeldCheck);
        return result;
    }

    /**
     *  Get all the ppLineWeldChecks.
     *  
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<PpLineWeldCheckDTO> findAll(Pageable pageable) {
        log.debug("Request to get all PpLineWeldChecks");
        Page<PpLineWeldCheck> result = ppLineWeldCheckRepository.findAll(pageable);
        return result.map(ppLineWeldCheck -> ppLineWeldCheckMapper.toDto(ppLineWeldCheck));
    }

    /**
     *  Get one ppLineWeldCheck by id.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public PpLineWeldCheckDTO findOne(Long id) {
        log.debug("Request to get PpLineWeldCheck : {}", id);
        PpLineWeldCheck ppLineWeldCheck = ppLineWeldCheckRepository.findOne(id);
        PpLineWeldCheckDTO ppLineWeldCheckDTO = ppLineWeldCheckMapper.toDto(ppLineWeldCheck);
        return ppLineWeldCheckDTO;
    }

    /**
     *  Delete the  ppLineWeldCheck by id.
     *
     *  @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete PpLineWeldCheck : {}", id);
        ppLineWeldCheckRepository.delete(id);
    }
}
