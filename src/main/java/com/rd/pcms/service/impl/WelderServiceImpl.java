package com.rd.pcms.service.impl;

import com.rd.pcms.service.WelderService;
import com.rd.pcms.domain.Welder;
import com.rd.pcms.repository.WelderRepository;
import com.rd.pcms.service.dto.WelderDTO;
import com.rd.pcms.service.mapper.WelderMapper;
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
 * Service Implementation for managing Welder.
 */
@Service
@Transactional
public class WelderServiceImpl implements WelderService{

    private final Logger log = LoggerFactory.getLogger(WelderServiceImpl.class);
    
    private final WelderRepository welderRepository;

    private final WelderMapper welderMapper;

    public WelderServiceImpl(WelderRepository welderRepository, WelderMapper welderMapper) {
        this.welderRepository = welderRepository;
        this.welderMapper = welderMapper;
    }

    /**
     * Save a welder.
     *
     * @param welderDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public WelderDTO save(WelderDTO welderDTO) {
        log.debug("Request to save Welder : {}", welderDTO);
        Welder welder = welderMapper.toEntity(welderDTO);
        welder = welderRepository.save(welder);
        WelderDTO result = welderMapper.toDto(welder);
        return result;
    }

    /**
     *  Get all the welders.
     *  
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<WelderDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Welders");
        Page<Welder> result = welderRepository.findAll(pageable);
        return result.map(welder -> welderMapper.toDto(welder));
    }

    /**
     *  Get one welder by id.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public WelderDTO findOne(Long id) {
        log.debug("Request to get Welder : {}", id);
        Welder welder = welderRepository.findOne(id);
        WelderDTO welderDTO = welderMapper.toDto(welder);
        return welderDTO;
    }

    /**
     *  Delete the  welder by id.
     *
     *  @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Welder : {}", id);
        welderRepository.delete(id);
    }
}
