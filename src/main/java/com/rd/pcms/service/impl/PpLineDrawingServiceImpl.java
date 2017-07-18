package com.rd.pcms.service.impl;

import com.rd.pcms.service.PpLineDrawingService;
import com.rd.pcms.domain.PpLineDrawing;
import com.rd.pcms.repository.PpLineDrawingRepository;
import com.rd.pcms.service.dto.PpLineDrawingDTO;
import com.rd.pcms.service.mapper.PpLineDrawingMapper;
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
 * Service Implementation for managing PpLineDrawing.
 */
@Service
@Transactional
public class PpLineDrawingServiceImpl implements PpLineDrawingService{

    private final Logger log = LoggerFactory.getLogger(PpLineDrawingServiceImpl.class);
    
    private final PpLineDrawingRepository ppLineDrawingRepository;

    private final PpLineDrawingMapper ppLineDrawingMapper;

    public PpLineDrawingServiceImpl(PpLineDrawingRepository ppLineDrawingRepository, PpLineDrawingMapper ppLineDrawingMapper) {
        this.ppLineDrawingRepository = ppLineDrawingRepository;
        this.ppLineDrawingMapper = ppLineDrawingMapper;
    }

    /**
     * Save a ppLineDrawing.
     *
     * @param ppLineDrawingDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public PpLineDrawingDTO save(PpLineDrawingDTO ppLineDrawingDTO) {
        log.debug("Request to save PpLineDrawing : {}", ppLineDrawingDTO);
        PpLineDrawing ppLineDrawing = ppLineDrawingMapper.toEntity(ppLineDrawingDTO);
        ppLineDrawing = ppLineDrawingRepository.save(ppLineDrawing);
        PpLineDrawingDTO result = ppLineDrawingMapper.toDto(ppLineDrawing);
        return result;
    }

    /**
     *  Get all the ppLineDrawings.
     *  
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<PpLineDrawingDTO> findAll(Pageable pageable) {
        log.debug("Request to get all PpLineDrawings");
        Page<PpLineDrawing> result = ppLineDrawingRepository.findAll(pageable);
        return result.map(ppLineDrawing -> ppLineDrawingMapper.toDto(ppLineDrawing));
    }

    /**
     *  Get one ppLineDrawing by id.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public PpLineDrawingDTO findOne(Long id) {
        log.debug("Request to get PpLineDrawing : {}", id);
        PpLineDrawing ppLineDrawing = ppLineDrawingRepository.findOne(id);
        PpLineDrawingDTO ppLineDrawingDTO = ppLineDrawingMapper.toDto(ppLineDrawing);
        return ppLineDrawingDTO;
    }

    /**
     *  Delete the  ppLineDrawing by id.
     *
     *  @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete PpLineDrawing : {}", id);
        ppLineDrawingRepository.delete(id);
    }
}
