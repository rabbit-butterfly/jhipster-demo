package com.rd.pcms.service.impl;

import com.rd.pcms.service.PpGradeMaterailService;
import com.rd.pcms.domain.PpGradeMaterail;
import com.rd.pcms.repository.PpGradeMaterailRepository;
import com.rd.pcms.service.dto.PpGradeMaterailDTO;
import com.rd.pcms.service.mapper.PpGradeMaterailMapper;
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
 * Service Implementation for managing PpGradeMaterail.
 */
@Service
@Transactional
public class PpGradeMaterailServiceImpl implements PpGradeMaterailService{

    private final Logger log = LoggerFactory.getLogger(PpGradeMaterailServiceImpl.class);
    
    private final PpGradeMaterailRepository ppGradeMaterailRepository;

    private final PpGradeMaterailMapper ppGradeMaterailMapper;

    public PpGradeMaterailServiceImpl(PpGradeMaterailRepository ppGradeMaterailRepository, PpGradeMaterailMapper ppGradeMaterailMapper) {
        this.ppGradeMaterailRepository = ppGradeMaterailRepository;
        this.ppGradeMaterailMapper = ppGradeMaterailMapper;
    }

    /**
     * Save a ppGradeMaterail.
     *
     * @param ppGradeMaterailDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public PpGradeMaterailDTO save(PpGradeMaterailDTO ppGradeMaterailDTO) {
        log.debug("Request to save PpGradeMaterail : {}", ppGradeMaterailDTO);
        PpGradeMaterail ppGradeMaterail = ppGradeMaterailMapper.toEntity(ppGradeMaterailDTO);
        ppGradeMaterail = ppGradeMaterailRepository.save(ppGradeMaterail);
        PpGradeMaterailDTO result = ppGradeMaterailMapper.toDto(ppGradeMaterail);
        return result;
    }

    /**
     *  Get all the ppGradeMaterails.
     *  
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<PpGradeMaterailDTO> findAll(Pageable pageable) {
        log.debug("Request to get all PpGradeMaterails");
        Page<PpGradeMaterail> result = ppGradeMaterailRepository.findAll(pageable);
        return result.map(ppGradeMaterail -> ppGradeMaterailMapper.toDto(ppGradeMaterail));
    }

    /**
     *  Get one ppGradeMaterail by id.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public PpGradeMaterailDTO findOne(Long id) {
        log.debug("Request to get PpGradeMaterail : {}", id);
        PpGradeMaterail ppGradeMaterail = ppGradeMaterailRepository.findOne(id);
        PpGradeMaterailDTO ppGradeMaterailDTO = ppGradeMaterailMapper.toDto(ppGradeMaterail);
        return ppGradeMaterailDTO;
    }

    /**
     *  Delete the  ppGradeMaterail by id.
     *
     *  @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete PpGradeMaterail : {}", id);
        ppGradeMaterailRepository.delete(id);
    }
}
