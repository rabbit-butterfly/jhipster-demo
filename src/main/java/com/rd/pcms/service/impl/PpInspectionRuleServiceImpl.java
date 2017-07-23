package com.rd.pcms.service.impl;

import com.rd.pcms.service.PpInspectionRuleService;
import com.rd.pcms.domain.PpInspectionRule;
import com.rd.pcms.repository.PpInspectionRuleRepository;
import com.rd.pcms.service.dto.PpInspectionRuleDTO;
import com.rd.pcms.service.mapper.PpInspectionRuleMapper;
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
 * Service Implementation for managing PpInspectionRule.
 */
@Service
@Transactional
public class PpInspectionRuleServiceImpl implements PpInspectionRuleService{

    private final Logger log = LoggerFactory.getLogger(PpInspectionRuleServiceImpl.class);
    
    private final PpInspectionRuleRepository ppInspectionRuleRepository;

    private final PpInspectionRuleMapper ppInspectionRuleMapper;

    public PpInspectionRuleServiceImpl(PpInspectionRuleRepository ppInspectionRuleRepository, PpInspectionRuleMapper ppInspectionRuleMapper) {
        this.ppInspectionRuleRepository = ppInspectionRuleRepository;
        this.ppInspectionRuleMapper = ppInspectionRuleMapper;
    }

    /**
     * Save a ppInspectionRule.
     *
     * @param ppInspectionRuleDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public PpInspectionRuleDTO save(PpInspectionRuleDTO ppInspectionRuleDTO) {
        log.debug("Request to save PpInspectionRule : {}", ppInspectionRuleDTO);
        PpInspectionRule ppInspectionRule = ppInspectionRuleMapper.toEntity(ppInspectionRuleDTO);
        ppInspectionRule = ppInspectionRuleRepository.save(ppInspectionRule);
        PpInspectionRuleDTO result = ppInspectionRuleMapper.toDto(ppInspectionRule);
        return result;
    }

    /**
     *  Get all the ppInspectionRules.
     *  
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<PpInspectionRuleDTO> findAll(Pageable pageable) {
        log.debug("Request to get all PpInspectionRules");
        Page<PpInspectionRule> result = ppInspectionRuleRepository.findAll(pageable);
        return result.map(ppInspectionRule -> ppInspectionRuleMapper.toDto(ppInspectionRule));
    }

    /**
     *  Get one ppInspectionRule by id.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public PpInspectionRuleDTO findOne(Long id) {
        log.debug("Request to get PpInspectionRule : {}", id);
        PpInspectionRule ppInspectionRule = ppInspectionRuleRepository.findOne(id);
        PpInspectionRuleDTO ppInspectionRuleDTO = ppInspectionRuleMapper.toDto(ppInspectionRule);
        return ppInspectionRuleDTO;
    }

    /**
     *  Delete the  ppInspectionRule by id.
     *
     *  @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete PpInspectionRule : {}", id);
        ppInspectionRuleRepository.delete(id);
    }
}
