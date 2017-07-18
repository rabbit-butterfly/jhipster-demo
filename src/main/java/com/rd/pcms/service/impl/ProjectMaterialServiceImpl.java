package com.rd.pcms.service.impl;

import com.rd.pcms.service.ProjectMaterialService;
import com.rd.pcms.domain.ProjectMaterial;
import com.rd.pcms.repository.ProjectMaterialRepository;
import com.rd.pcms.service.dto.ProjectMaterialDTO;
import com.rd.pcms.service.mapper.ProjectMaterialMapper;
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
 * Service Implementation for managing ProjectMaterial.
 */
@Service
@Transactional
public class ProjectMaterialServiceImpl implements ProjectMaterialService{

    private final Logger log = LoggerFactory.getLogger(ProjectMaterialServiceImpl.class);
    
    private final ProjectMaterialRepository projectMaterialRepository;

    private final ProjectMaterialMapper projectMaterialMapper;

    public ProjectMaterialServiceImpl(ProjectMaterialRepository projectMaterialRepository, ProjectMaterialMapper projectMaterialMapper) {
        this.projectMaterialRepository = projectMaterialRepository;
        this.projectMaterialMapper = projectMaterialMapper;
    }

    /**
     * Save a projectMaterial.
     *
     * @param projectMaterialDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public ProjectMaterialDTO save(ProjectMaterialDTO projectMaterialDTO) {
        log.debug("Request to save ProjectMaterial : {}", projectMaterialDTO);
        ProjectMaterial projectMaterial = projectMaterialMapper.toEntity(projectMaterialDTO);
        projectMaterial = projectMaterialRepository.save(projectMaterial);
        ProjectMaterialDTO result = projectMaterialMapper.toDto(projectMaterial);
        return result;
    }

    /**
     *  Get all the projectMaterials.
     *  
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<ProjectMaterialDTO> findAll(Pageable pageable) {
        log.debug("Request to get all ProjectMaterials");
        Page<ProjectMaterial> result = projectMaterialRepository.findAll(pageable);
        return result.map(projectMaterial -> projectMaterialMapper.toDto(projectMaterial));
    }

    /**
     *  Get one projectMaterial by id.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public ProjectMaterialDTO findOne(Long id) {
        log.debug("Request to get ProjectMaterial : {}", id);
        ProjectMaterial projectMaterial = projectMaterialRepository.findOne(id);
        ProjectMaterialDTO projectMaterialDTO = projectMaterialMapper.toDto(projectMaterial);
        return projectMaterialDTO;
    }

    /**
     *  Delete the  projectMaterial by id.
     *
     *  @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete ProjectMaterial : {}", id);
        projectMaterialRepository.delete(id);
    }
}
