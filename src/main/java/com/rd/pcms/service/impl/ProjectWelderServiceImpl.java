package com.rd.pcms.service.impl;

import com.rd.pcms.service.ProjectWelderService;
import com.rd.pcms.domain.ProjectWelder;
import com.rd.pcms.repository.ProjectWelderRepository;
import com.rd.pcms.service.dto.ProjectWelderDTO;
import com.rd.pcms.service.mapper.ProjectWelderMapper;
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
 * Service Implementation for managing ProjectWelder.
 */
@Service
@Transactional
public class ProjectWelderServiceImpl implements ProjectWelderService{

    private final Logger log = LoggerFactory.getLogger(ProjectWelderServiceImpl.class);
    
    private final ProjectWelderRepository projectWelderRepository;

    private final ProjectWelderMapper projectWelderMapper;

    public ProjectWelderServiceImpl(ProjectWelderRepository projectWelderRepository, ProjectWelderMapper projectWelderMapper) {
        this.projectWelderRepository = projectWelderRepository;
        this.projectWelderMapper = projectWelderMapper;
    }

    /**
     * Save a projectWelder.
     *
     * @param projectWelderDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public ProjectWelderDTO save(ProjectWelderDTO projectWelderDTO) {
        log.debug("Request to save ProjectWelder : {}", projectWelderDTO);
        ProjectWelder projectWelder = projectWelderMapper.toEntity(projectWelderDTO);
        projectWelder = projectWelderRepository.save(projectWelder);
        ProjectWelderDTO result = projectWelderMapper.toDto(projectWelder);
        return result;
    }

    /**
     *  Get all the projectWelders.
     *  
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<ProjectWelderDTO> findAll(Pageable pageable) {
        log.debug("Request to get all ProjectWelders");
        Page<ProjectWelder> result = projectWelderRepository.findAll(pageable);
        return result.map(projectWelder -> projectWelderMapper.toDto(projectWelder));
    }

    /**
     *  Get one projectWelder by id.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public ProjectWelderDTO findOne(Long id) {
        log.debug("Request to get ProjectWelder : {}", id);
        ProjectWelder projectWelder = projectWelderRepository.findOne(id);
        ProjectWelderDTO projectWelderDTO = projectWelderMapper.toDto(projectWelder);
        return projectWelderDTO;
    }

    /**
     *  Delete the  projectWelder by id.
     *
     *  @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete ProjectWelder : {}", id);
        projectWelderRepository.delete(id);
    }
}
