package com.rd.pcms.service.impl;

import com.rd.pcms.service.ProjectSpecService;
import com.rd.pcms.domain.ProjectSpec;
import com.rd.pcms.repository.ProjectSpecRepository;
import com.rd.pcms.service.dto.ProjectSpecDTO;
import com.rd.pcms.service.mapper.ProjectSpecMapper;
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
 * Service Implementation for managing ProjectSpec.
 */
@Service
@Transactional
public class ProjectSpecServiceImpl implements ProjectSpecService{

    private final Logger log = LoggerFactory.getLogger(ProjectSpecServiceImpl.class);
    
    private final ProjectSpecRepository projectSpecRepository;

    private final ProjectSpecMapper projectSpecMapper;

    public ProjectSpecServiceImpl(ProjectSpecRepository projectSpecRepository, ProjectSpecMapper projectSpecMapper) {
        this.projectSpecRepository = projectSpecRepository;
        this.projectSpecMapper = projectSpecMapper;
    }

    /**
     * Save a projectSpec.
     *
     * @param projectSpecDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public ProjectSpecDTO save(ProjectSpecDTO projectSpecDTO) {
        log.debug("Request to save ProjectSpec : {}", projectSpecDTO);
        ProjectSpec projectSpec = projectSpecMapper.toEntity(projectSpecDTO);
        projectSpec = projectSpecRepository.save(projectSpec);
        ProjectSpecDTO result = projectSpecMapper.toDto(projectSpec);
        return result;
    }

    /**
     *  Get all the projectSpecs.
     *  
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<ProjectSpecDTO> findAll(Pageable pageable) {
        log.debug("Request to get all ProjectSpecs");
        Page<ProjectSpec> result = projectSpecRepository.findAll(pageable);
        return result.map(projectSpec -> projectSpecMapper.toDto(projectSpec));
    }

    /**
     *  Get one projectSpec by id.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public ProjectSpecDTO findOne(Long id) {
        log.debug("Request to get ProjectSpec : {}", id);
        ProjectSpec projectSpec = projectSpecRepository.findOne(id);
        ProjectSpecDTO projectSpecDTO = projectSpecMapper.toDto(projectSpec);
        return projectSpecDTO;
    }

    /**
     *  Delete the  projectSpec by id.
     *
     *  @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete ProjectSpec : {}", id);
        projectSpecRepository.delete(id);
    }
}
