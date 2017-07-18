package com.rd.pcms.service.impl;

import com.rd.pcms.service.PpLineWeldEntrustService;
import com.rd.pcms.domain.PpLineWeldEntrust;
import com.rd.pcms.repository.PpLineWeldEntrustRepository;
import com.rd.pcms.service.dto.PpLineWeldEntrustDTO;
import com.rd.pcms.service.mapper.PpLineWeldEntrustMapper;
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
 * Service Implementation for managing PpLineWeldEntrust.
 */
@Service
@Transactional
public class PpLineWeldEntrustServiceImpl implements PpLineWeldEntrustService{

    private final Logger log = LoggerFactory.getLogger(PpLineWeldEntrustServiceImpl.class);
    
    private final PpLineWeldEntrustRepository ppLineWeldEntrustRepository;

    private final PpLineWeldEntrustMapper ppLineWeldEntrustMapper;

    public PpLineWeldEntrustServiceImpl(PpLineWeldEntrustRepository ppLineWeldEntrustRepository, PpLineWeldEntrustMapper ppLineWeldEntrustMapper) {
        this.ppLineWeldEntrustRepository = ppLineWeldEntrustRepository;
        this.ppLineWeldEntrustMapper = ppLineWeldEntrustMapper;
    }

    /**
     * Save a ppLineWeldEntrust.
     *
     * @param ppLineWeldEntrustDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public PpLineWeldEntrustDTO save(PpLineWeldEntrustDTO ppLineWeldEntrustDTO) {
        log.debug("Request to save PpLineWeldEntrust : {}", ppLineWeldEntrustDTO);
        PpLineWeldEntrust ppLineWeldEntrust = ppLineWeldEntrustMapper.toEntity(ppLineWeldEntrustDTO);
        ppLineWeldEntrust = ppLineWeldEntrustRepository.save(ppLineWeldEntrust);
        PpLineWeldEntrustDTO result = ppLineWeldEntrustMapper.toDto(ppLineWeldEntrust);
        return result;
    }

    /**
     *  Get all the ppLineWeldEntrusts.
     *  
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<PpLineWeldEntrustDTO> findAll(Pageable pageable) {
        log.debug("Request to get all PpLineWeldEntrusts");
        Page<PpLineWeldEntrust> result = ppLineWeldEntrustRepository.findAll(pageable);
        return result.map(ppLineWeldEntrust -> ppLineWeldEntrustMapper.toDto(ppLineWeldEntrust));
    }

    /**
     *  Get one ppLineWeldEntrust by id.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public PpLineWeldEntrustDTO findOne(Long id) {
        log.debug("Request to get PpLineWeldEntrust : {}", id);
        PpLineWeldEntrust ppLineWeldEntrust = ppLineWeldEntrustRepository.findOne(id);
        PpLineWeldEntrustDTO ppLineWeldEntrustDTO = ppLineWeldEntrustMapper.toDto(ppLineWeldEntrust);
        return ppLineWeldEntrustDTO;
    }

    /**
     *  Delete the  ppLineWeldEntrust by id.
     *
     *  @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete PpLineWeldEntrust : {}", id);
        ppLineWeldEntrustRepository.delete(id);
    }
}
