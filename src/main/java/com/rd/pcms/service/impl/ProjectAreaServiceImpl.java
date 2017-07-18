package com.rd.pcms.service.impl;

import com.rd.pcms.service.ProjectAreaService;
import com.rd.pcms.domain.ProjectArea;
import com.rd.pcms.repository.ProjectAreaRepository;
import com.rd.pcms.service.dto.ProjectAreaDTO;
import com.rd.pcms.service.mapper.ProjectAreaMapper;
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
 * Service Implementation for managing ProjectArea.
 */
@Service
@Transactional
public class ProjectAreaServiceImpl implements ProjectAreaService{

    private final Logger log = LoggerFactory.getLogger(ProjectAreaServiceImpl.class);
    
    private final ProjectAreaRepository projectAreaRepository;

    private final ProjectAreaMapper projectAreaMapper;

    public ProjectAreaServiceImpl(ProjectAreaRepository projectAreaRepository, ProjectAreaMapper projectAreaMapper) {
        this.projectAreaRepository = projectAreaRepository;
        this.projectAreaMapper = projectAreaMapper;
    }

    /**
     * Save a projectArea.
     *
     * @param projectAreaDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public ProjectAreaDTO save(ProjectAreaDTO projectAreaDTO) {
        log.debug("Request to save ProjectArea : {}", projectAreaDTO);
        ProjectArea projectArea = projectAreaMapper.toEntity(projectAreaDTO);
        projectArea = projectAreaRepository.save(projectArea);
        ProjectAreaDTO result = projectAreaMapper.toDto(projectArea);
        return result;
    }

    /**
     *  Get all the projectAreas.
     *  
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<ProjectAreaDTO> findAll(Pageable pageable) {
        log.debug("Request to get all ProjectAreas");
        Page<ProjectArea> result = projectAreaRepository.findAll(pageable);
        return result.map(projectArea -> projectAreaMapper.toDto(projectArea));
    }

    /**
     *  Get one projectArea by id.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public ProjectAreaDTO findOne(Long id) {
        log.debug("Request to get ProjectArea : {}", id);
        ProjectArea projectArea = projectAreaRepository.findOne(id);
        ProjectAreaDTO projectAreaDTO = projectAreaMapper.toDto(projectArea);
        return projectAreaDTO;
    }

    /**
     *  Delete the  projectArea by id.
     *
     *  @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete ProjectArea : {}", id);
        projectAreaRepository.delete(id);
    }
}
