package com.rd.pcms.service.impl;

import com.rd.pcms.service.PpLineWeldMaterialService;
import com.rd.pcms.domain.PpLineWeldMaterial;
import com.rd.pcms.repository.PpLineWeldMaterialRepository;
import com.rd.pcms.service.dto.PpLineWeldMaterialDTO;
import com.rd.pcms.service.mapper.PpLineWeldMaterialMapper;
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
 * Service Implementation for managing PpLineWeldMaterial.
 */
@Service
@Transactional
public class PpLineWeldMaterialServiceImpl implements PpLineWeldMaterialService{

    private final Logger log = LoggerFactory.getLogger(PpLineWeldMaterialServiceImpl.class);
    
    private final PpLineWeldMaterialRepository ppLineWeldMaterialRepository;

    private final PpLineWeldMaterialMapper ppLineWeldMaterialMapper;

    public PpLineWeldMaterialServiceImpl(PpLineWeldMaterialRepository ppLineWeldMaterialRepository, PpLineWeldMaterialMapper ppLineWeldMaterialMapper) {
        this.ppLineWeldMaterialRepository = ppLineWeldMaterialRepository;
        this.ppLineWeldMaterialMapper = ppLineWeldMaterialMapper;
    }

    /**
     * Save a ppLineWeldMaterial.
     *
     * @param ppLineWeldMaterialDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public PpLineWeldMaterialDTO save(PpLineWeldMaterialDTO ppLineWeldMaterialDTO) {
        log.debug("Request to save PpLineWeldMaterial : {}", ppLineWeldMaterialDTO);
        PpLineWeldMaterial ppLineWeldMaterial = ppLineWeldMaterialMapper.toEntity(ppLineWeldMaterialDTO);
        ppLineWeldMaterial = ppLineWeldMaterialRepository.save(ppLineWeldMaterial);
        PpLineWeldMaterialDTO result = ppLineWeldMaterialMapper.toDto(ppLineWeldMaterial);
        return result;
    }

    /**
     *  Get all the ppLineWeldMaterials.
     *  
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<PpLineWeldMaterialDTO> findAll(Pageable pageable) {
        log.debug("Request to get all PpLineWeldMaterials");
        Page<PpLineWeldMaterial> result = ppLineWeldMaterialRepository.findAll(pageable);
        return result.map(ppLineWeldMaterial -> ppLineWeldMaterialMapper.toDto(ppLineWeldMaterial));
    }

    /**
     *  Get one ppLineWeldMaterial by id.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public PpLineWeldMaterialDTO findOne(Long id) {
        log.debug("Request to get PpLineWeldMaterial : {}", id);
        PpLineWeldMaterial ppLineWeldMaterial = ppLineWeldMaterialRepository.findOne(id);
        PpLineWeldMaterialDTO ppLineWeldMaterialDTO = ppLineWeldMaterialMapper.toDto(ppLineWeldMaterial);
        return ppLineWeldMaterialDTO;
    }

    /**
     *  Delete the  ppLineWeldMaterial by id.
     *
     *  @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete PpLineWeldMaterial : {}", id);
        ppLineWeldMaterialRepository.delete(id);
    }
}
