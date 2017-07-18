package com.rd.pcms.service.impl;

import com.rd.pcms.service.UserAreaService;
import com.rd.pcms.domain.UserArea;
import com.rd.pcms.repository.UserAreaRepository;
import com.rd.pcms.service.dto.UserAreaDTO;
import com.rd.pcms.service.mapper.UserAreaMapper;
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
 * Service Implementation for managing UserArea.
 */
@Service
@Transactional
public class UserAreaServiceImpl implements UserAreaService{

    private final Logger log = LoggerFactory.getLogger(UserAreaServiceImpl.class);
    
    private final UserAreaRepository userAreaRepository;

    private final UserAreaMapper userAreaMapper;

    public UserAreaServiceImpl(UserAreaRepository userAreaRepository, UserAreaMapper userAreaMapper) {
        this.userAreaRepository = userAreaRepository;
        this.userAreaMapper = userAreaMapper;
    }

    /**
     * Save a userArea.
     *
     * @param userAreaDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public UserAreaDTO save(UserAreaDTO userAreaDTO) {
        log.debug("Request to save UserArea : {}", userAreaDTO);
        UserArea userArea = userAreaMapper.toEntity(userAreaDTO);
        userArea = userAreaRepository.save(userArea);
        UserAreaDTO result = userAreaMapper.toDto(userArea);
        return result;
    }

    /**
     *  Get all the userAreas.
     *  
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<UserAreaDTO> findAll(Pageable pageable) {
        log.debug("Request to get all UserAreas");
        Page<UserArea> result = userAreaRepository.findAll(pageable);
        return result.map(userArea -> userAreaMapper.toDto(userArea));
    }

    /**
     *  Get one userArea by id.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public UserAreaDTO findOne(Long id) {
        log.debug("Request to get UserArea : {}", id);
        UserArea userArea = userAreaRepository.findOne(id);
        UserAreaDTO userAreaDTO = userAreaMapper.toDto(userArea);
        return userAreaDTO;
    }

    /**
     *  Delete the  userArea by id.
     *
     *  @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete UserArea : {}", id);
        userAreaRepository.delete(id);
    }
}
