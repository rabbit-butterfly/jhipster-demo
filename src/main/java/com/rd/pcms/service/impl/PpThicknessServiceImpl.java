package com.rd.pcms.service.impl;

import com.rd.pcms.service.PpThicknessService;
import com.rd.pcms.domain.PpThickness;
import com.rd.pcms.repository.PpThicknessRepository;
import com.rd.pcms.service.dto.PpThicknessDTO;
import com.rd.pcms.service.mapper.PpThicknessMapper;
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
 * Service Implementation for managing PpThickness.
 */
@Service
@Transactional
public class PpThicknessServiceImpl implements PpThicknessService{

    private final Logger log = LoggerFactory.getLogger(PpThicknessServiceImpl.class);
    
    private final PpThicknessRepository ppThicknessRepository;

    private final PpThicknessMapper ppThicknessMapper;

    public PpThicknessServiceImpl(PpThicknessRepository ppThicknessRepository, PpThicknessMapper ppThicknessMapper) {
        this.ppThicknessRepository = ppThicknessRepository;
        this.ppThicknessMapper = ppThicknessMapper;
    }

    /**
     * Save a ppThickness.
     *
     * @param ppThicknessDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public PpThicknessDTO save(PpThicknessDTO ppThicknessDTO) {
        log.debug("Request to save PpThickness : {}", ppThicknessDTO);
        PpThickness ppThickness = ppThicknessMapper.toEntity(ppThicknessDTO);
        ppThickness = ppThicknessRepository.save(ppThickness);
        PpThicknessDTO result = ppThicknessMapper.toDto(ppThickness);
        return result;
    }

    /**
     *  Get all the ppThicknesses.
     *  
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<PpThicknessDTO> findAll(Pageable pageable) {
        log.debug("Request to get all PpThicknesses");
        Page<PpThickness> result = ppThicknessRepository.findAll(pageable);
        return result.map(ppThickness -> ppThicknessMapper.toDto(ppThickness));
    }

    /**
     *  Get one ppThickness by id.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public PpThicknessDTO findOne(Long id) {
        log.debug("Request to get PpThickness : {}", id);
        PpThickness ppThickness = ppThicknessRepository.findOne(id);
        PpThicknessDTO ppThicknessDTO = ppThicknessMapper.toDto(ppThickness);
        return ppThicknessDTO;
    }

    /**
     *  Delete the  ppThickness by id.
     *
     *  @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete PpThickness : {}", id);
        ppThicknessRepository.delete(id);
    }
}
