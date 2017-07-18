package com.rd.pcms.service.impl;

import com.rd.pcms.service.ProjectSubConstractorService;
import com.rd.pcms.domain.ProjectSubConstractor;
import com.rd.pcms.repository.ProjectSubConstractorRepository;
import com.rd.pcms.service.dto.ProjectSubConstractorDTO;
import com.rd.pcms.service.mapper.ProjectSubConstractorMapper;
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
 * Service Implementation for managing ProjectSubConstractor.
 */
@Service
@Transactional
public class ProjectSubConstractorServiceImpl implements ProjectSubConstractorService{

    private final Logger log = LoggerFactory.getLogger(ProjectSubConstractorServiceImpl.class);
    
    private final ProjectSubConstractorRepository projectSubConstractorRepository;

    private final ProjectSubConstractorMapper projectSubConstractorMapper;

    public ProjectSubConstractorServiceImpl(ProjectSubConstractorRepository projectSubConstractorRepository, ProjectSubConstractorMapper projectSubConstractorMapper) {
        this.projectSubConstractorRepository = projectSubConstractorRepository;
        this.projectSubConstractorMapper = projectSubConstractorMapper;
    }

    /**
     * Save a projectSubConstractor.
     *
     * @param projectSubConstractorDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public ProjectSubConstractorDTO save(ProjectSubConstractorDTO projectSubConstractorDTO) {
        log.debug("Request to save ProjectSubConstractor : {}", projectSubConstractorDTO);
        ProjectSubConstractor projectSubConstractor = projectSubConstractorMapper.toEntity(projectSubConstractorDTO);
        projectSubConstractor = projectSubConstractorRepository.save(projectSubConstractor);
        ProjectSubConstractorDTO result = projectSubConstractorMapper.toDto(projectSubConstractor);
        return result;
    }

    /**
     *  Get all the projectSubConstractors.
     *  
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<ProjectSubConstractorDTO> findAll(Pageable pageable) {
        log.debug("Request to get all ProjectSubConstractors");
        Page<ProjectSubConstractor> result = projectSubConstractorRepository.findAll(pageable);
        return result.map(projectSubConstractor -> projectSubConstractorMapper.toDto(projectSubConstractor));
    }

    /**
     *  Get one projectSubConstractor by id.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public ProjectSubConstractorDTO findOne(Long id) {
        log.debug("Request to get ProjectSubConstractor : {}", id);
        ProjectSubConstractor projectSubConstractor = projectSubConstractorRepository.findOne(id);
        ProjectSubConstractorDTO projectSubConstractorDTO = projectSubConstractorMapper.toDto(projectSubConstractor);
        return projectSubConstractorDTO;
    }

    /**
     *  Delete the  projectSubConstractor by id.
     *
     *  @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete ProjectSubConstractor : {}", id);
        projectSubConstractorRepository.delete(id);
    }
}
