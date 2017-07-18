package com.rd.pcms.service.impl;

import com.rd.pcms.service.PpIinspectionTatioService;
import com.rd.pcms.domain.PpIinspectionTatio;
import com.rd.pcms.repository.PpIinspectionTatioRepository;
import com.rd.pcms.service.dto.PpIinspectionTatioDTO;
import com.rd.pcms.service.mapper.PpIinspectionTatioMapper;
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
 * Service Implementation for managing PpIinspectionTatio.
 */
@Service
@Transactional
public class PpIinspectionTatioServiceImpl implements PpIinspectionTatioService{

    private final Logger log = LoggerFactory.getLogger(PpIinspectionTatioServiceImpl.class);
    
    private final PpIinspectionTatioRepository ppIinspectionTatioRepository;

    private final PpIinspectionTatioMapper ppIinspectionTatioMapper;

    public PpIinspectionTatioServiceImpl(PpIinspectionTatioRepository ppIinspectionTatioRepository, PpIinspectionTatioMapper ppIinspectionTatioMapper) {
        this.ppIinspectionTatioRepository = ppIinspectionTatioRepository;
        this.ppIinspectionTatioMapper = ppIinspectionTatioMapper;
    }

    /**
     * Save a ppIinspectionTatio.
     *
     * @param ppIinspectionTatioDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public PpIinspectionTatioDTO save(PpIinspectionTatioDTO ppIinspectionTatioDTO) {
        log.debug("Request to save PpIinspectionTatio : {}", ppIinspectionTatioDTO);
        PpIinspectionTatio ppIinspectionTatio = ppIinspectionTatioMapper.toEntity(ppIinspectionTatioDTO);
        ppIinspectionTatio = ppIinspectionTatioRepository.save(ppIinspectionTatio);
        PpIinspectionTatioDTO result = ppIinspectionTatioMapper.toDto(ppIinspectionTatio);
        return result;
    }

    /**
     *  Get all the ppIinspectionTatios.
     *  
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<PpIinspectionTatioDTO> findAll(Pageable pageable) {
        log.debug("Request to get all PpIinspectionTatios");
        Page<PpIinspectionTatio> result = ppIinspectionTatioRepository.findAll(pageable);
        return result.map(ppIinspectionTatio -> ppIinspectionTatioMapper.toDto(ppIinspectionTatio));
    }

    /**
     *  Get one ppIinspectionTatio by id.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public PpIinspectionTatioDTO findOne(Long id) {
        log.debug("Request to get PpIinspectionTatio : {}", id);
        PpIinspectionTatio ppIinspectionTatio = ppIinspectionTatioRepository.findOne(id);
        PpIinspectionTatioDTO ppIinspectionTatioDTO = ppIinspectionTatioMapper.toDto(ppIinspectionTatio);
        return ppIinspectionTatioDTO;
    }

    /**
     *  Delete the  ppIinspectionTatio by id.
     *
     *  @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete PpIinspectionTatio : {}", id);
        ppIinspectionTatioRepository.delete(id);
    }
}
