package com.rd.pcms.service.impl;

import com.rd.pcms.service.UserPowerService;
import com.rd.pcms.domain.UserPower;
import com.rd.pcms.repository.UserPowerRepository;
import com.rd.pcms.service.dto.UserPowerDTO;
import com.rd.pcms.service.mapper.UserPowerMapper;
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
 * Service Implementation for managing UserPower.
 */
@Service
@Transactional
public class UserPowerServiceImpl implements UserPowerService{

    private final Logger log = LoggerFactory.getLogger(UserPowerServiceImpl.class);
    
    private final UserPowerRepository userPowerRepository;

    private final UserPowerMapper userPowerMapper;

    public UserPowerServiceImpl(UserPowerRepository userPowerRepository, UserPowerMapper userPowerMapper) {
        this.userPowerRepository = userPowerRepository;
        this.userPowerMapper = userPowerMapper;
    }

    /**
     * Save a userPower.
     *
     * @param userPowerDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public UserPowerDTO save(UserPowerDTO userPowerDTO) {
        log.debug("Request to save UserPower : {}", userPowerDTO);
        UserPower userPower = userPowerMapper.toEntity(userPowerDTO);
        userPower = userPowerRepository.save(userPower);
        UserPowerDTO result = userPowerMapper.toDto(userPower);
        return result;
    }

    /**
     *  Get all the userPowers.
     *  
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<UserPowerDTO> findAll(Pageable pageable) {
        log.debug("Request to get all UserPowers");
        Page<UserPower> result = userPowerRepository.findAll(pageable);
        return result.map(userPower -> userPowerMapper.toDto(userPower));
    }

    /**
     *  Get one userPower by id.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public UserPowerDTO findOne(Long id) {
        log.debug("Request to get UserPower : {}", id);
        UserPower userPower = userPowerRepository.findOne(id);
        UserPowerDTO userPowerDTO = userPowerMapper.toDto(userPower);
        return userPowerDTO;
    }

    /**
     *  Delete the  userPower by id.
     *
     *  @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete UserPower : {}", id);
        userPowerRepository.delete(id);
    }
}
