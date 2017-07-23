package com.rd.pcms.service.impl;

import com.rd.pcms.service.PpLineService;
import com.rd.pcms.domain.PpLine;
import com.rd.pcms.repository.PpLineRepository;
import com.rd.pcms.service.dto.PpLineDTO;
import com.rd.pcms.service.mapper.PpLineMapper;
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
 * Service Implementation for managing PpLine.
 */
@Service
@Transactional
public class PpLineServiceImpl implements PpLineService{

    private final Logger log = LoggerFactory.getLogger(PpLineServiceImpl.class);
    
    private final PpLineRepository ppLineRepository;

    private final PpLineMapper ppLineMapper;

    public PpLineServiceImpl(PpLineRepository ppLineRepository, PpLineMapper ppLineMapper) {
        this.ppLineRepository = ppLineRepository;
        this.ppLineMapper = ppLineMapper;
    }

    /**
     * Save a ppLine.
     *
     * @param ppLineDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public PpLineDTO save(PpLineDTO ppLineDTO) {
        log.debug("Request to save PpLine : {}", ppLineDTO);
        PpLine ppLine = ppLineMapper.toEntity(ppLineDTO);
        ppLine = ppLineRepository.save(ppLine);
        PpLineDTO result = ppLineMapper.toDto(ppLine);
        return result;
    }

    /**
     *  Get all the ppLines.
     *  
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<PpLineDTO> findAll(Pageable pageable) {
        log.debug("Request to get all PpLines");
        Page<PpLine> result = ppLineRepository.findAll(pageable);
        return result.map(ppLine -> ppLineMapper.toDto(ppLine));
    }

    /**
     *  Get one ppLine by id.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public PpLineDTO findOne(Long id) {
        log.debug("Request to get PpLine : {}", id);
        PpLine ppLine = ppLineRepository.findOne(id);
        PpLineDTO ppLineDTO = ppLineMapper.toDto(ppLine);
        return ppLineDTO;
    }

    /**
     *  Delete the  ppLine by id.
     *
     *  @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete PpLine : {}", id);
        ppLineRepository.delete(id);
    }
}
