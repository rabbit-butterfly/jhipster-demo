package com.rd.pcms.service.impl;

import com.rd.pcms.service.ProjectUserService;
import com.rd.pcms.domain.ProjectUser;
import com.rd.pcms.repository.ProjectUserRepository;
import com.rd.pcms.service.dto.ProjectUserDTO;
import com.rd.pcms.service.mapper.ProjectUserMapper;
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
 * Service Implementation for managing ProjectUser.
 */
@Service
@Transactional
public class ProjectUserServiceImpl implements ProjectUserService{

    private final Logger log = LoggerFactory.getLogger(ProjectUserServiceImpl.class);
    
    private final ProjectUserRepository projectUserRepository;

    private final ProjectUserMapper projectUserMapper;

    public ProjectUserServiceImpl(ProjectUserRepository projectUserRepository, ProjectUserMapper projectUserMapper) {
        this.projectUserRepository = projectUserRepository;
        this.projectUserMapper = projectUserMapper;
    }

    /**
     * Save a projectUser.
     *
     * @param projectUserDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public ProjectUserDTO save(ProjectUserDTO projectUserDTO) {
        log.debug("Request to save ProjectUser : {}", projectUserDTO);
        ProjectUser projectUser = projectUserMapper.toEntity(projectUserDTO);
        projectUser = projectUserRepository.save(projectUser);
        ProjectUserDTO result = projectUserMapper.toDto(projectUser);
        return result;
    }

    /**
     *  Get all the projectUsers.
     *  
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<ProjectUserDTO> findAll(Pageable pageable) {
        log.debug("Request to get all ProjectUsers");
        Page<ProjectUser> result = projectUserRepository.findAll(pageable);
        return result.map(projectUser -> projectUserMapper.toDto(projectUser));
    }

    /**
     *  Get one projectUser by id.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public ProjectUserDTO findOne(Long id) {
        log.debug("Request to get ProjectUser : {}", id);
        ProjectUser projectUser = projectUserRepository.findOne(id);
        ProjectUserDTO projectUserDTO = projectUserMapper.toDto(projectUser);
        return projectUserDTO;
    }

    /**
     *  Delete the  projectUser by id.
     *
     *  @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete ProjectUser : {}", id);
        projectUserRepository.delete(id);
    }
}
