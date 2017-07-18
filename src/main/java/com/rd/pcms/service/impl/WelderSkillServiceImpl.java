package com.rd.pcms.service.impl;

import com.rd.pcms.service.WelderSkillService;
import com.rd.pcms.domain.WelderSkill;
import com.rd.pcms.repository.WelderSkillRepository;
import com.rd.pcms.service.dto.WelderSkillDTO;
import com.rd.pcms.service.mapper.WelderSkillMapper;
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
 * Service Implementation for managing WelderSkill.
 */
@Service
@Transactional
public class WelderSkillServiceImpl implements WelderSkillService{

    private final Logger log = LoggerFactory.getLogger(WelderSkillServiceImpl.class);
    
    private final WelderSkillRepository welderSkillRepository;

    private final WelderSkillMapper welderSkillMapper;

    public WelderSkillServiceImpl(WelderSkillRepository welderSkillRepository, WelderSkillMapper welderSkillMapper) {
        this.welderSkillRepository = welderSkillRepository;
        this.welderSkillMapper = welderSkillMapper;
    }

    /**
     * Save a welderSkill.
     *
     * @param welderSkillDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public WelderSkillDTO save(WelderSkillDTO welderSkillDTO) {
        log.debug("Request to save WelderSkill : {}", welderSkillDTO);
        WelderSkill welderSkill = welderSkillMapper.toEntity(welderSkillDTO);
        welderSkill = welderSkillRepository.save(welderSkill);
        WelderSkillDTO result = welderSkillMapper.toDto(welderSkill);
        return result;
    }

    /**
     *  Get all the welderSkills.
     *  
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<WelderSkillDTO> findAll(Pageable pageable) {
        log.debug("Request to get all WelderSkills");
        Page<WelderSkill> result = welderSkillRepository.findAll(pageable);
        return result.map(welderSkill -> welderSkillMapper.toDto(welderSkill));
    }

    /**
     *  Get one welderSkill by id.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public WelderSkillDTO findOne(Long id) {
        log.debug("Request to get WelderSkill : {}", id);
        WelderSkill welderSkill = welderSkillRepository.findOne(id);
        WelderSkillDTO welderSkillDTO = welderSkillMapper.toDto(welderSkill);
        return welderSkillDTO;
    }

    /**
     *  Delete the  welderSkill by id.
     *
     *  @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete WelderSkill : {}", id);
        welderSkillRepository.delete(id);
    }
}
