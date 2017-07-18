package com.rd.pcms.service.impl;

import com.rd.pcms.service.PpLineWeldService;
import com.rd.pcms.domain.PpLineWeld;
import com.rd.pcms.repository.PpLineWeldRepository;
import com.rd.pcms.service.dto.PpLineWeldDTO;
import com.rd.pcms.service.mapper.PpLineWeldMapper;
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
 * Service Implementation for managing PpLineWeld.
 */
@Service
@Transactional
public class PpLineWeldServiceImpl implements PpLineWeldService{

    private final Logger log = LoggerFactory.getLogger(PpLineWeldServiceImpl.class);
    
    private final PpLineWeldRepository ppLineWeldRepository;

    private final PpLineWeldMapper ppLineWeldMapper;

    public PpLineWeldServiceImpl(PpLineWeldRepository ppLineWeldRepository, PpLineWeldMapper ppLineWeldMapper) {
        this.ppLineWeldRepository = ppLineWeldRepository;
        this.ppLineWeldMapper = ppLineWeldMapper;
    }

    /**
     * Save a ppLineWeld.
     *
     * @param ppLineWeldDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public PpLineWeldDTO save(PpLineWeldDTO ppLineWeldDTO) {
        log.debug("Request to save PpLineWeld : {}", ppLineWeldDTO);
        PpLineWeld ppLineWeld = ppLineWeldMapper.toEntity(ppLineWeldDTO);
        ppLineWeld = ppLineWeldRepository.save(ppLineWeld);
        PpLineWeldDTO result = ppLineWeldMapper.toDto(ppLineWeld);
        return result;
    }

    /**
     *  Get all the ppLineWelds.
     *  
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<PpLineWeldDTO> findAll(Pageable pageable) {
        log.debug("Request to get all PpLineWelds");
        Page<PpLineWeld> result = ppLineWeldRepository.findAll(pageable);
        return result.map(ppLineWeld -> ppLineWeldMapper.toDto(ppLineWeld));
    }

    /**
     *  Get one ppLineWeld by id.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public PpLineWeldDTO findOne(Long id) {
        log.debug("Request to get PpLineWeld : {}", id);
        PpLineWeld ppLineWeld = ppLineWeldRepository.findOne(id);
        PpLineWeldDTO ppLineWeldDTO = ppLineWeldMapper.toDto(ppLineWeld);
        return ppLineWeldDTO;
    }

    /**
     *  Delete the  ppLineWeld by id.
     *
     *  @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete PpLineWeld : {}", id);
        ppLineWeldRepository.delete(id);
    }
}
