package com.rd.pcms.service.impl;

import com.rd.pcms.service.RoleService;
import com.rd.pcms.domain.Role;
import com.rd.pcms.repository.RoleRepository;
import com.rd.pcms.service.dto.RoleDTO;
import com.rd.pcms.service.mapper.RoleMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Service Implementation for managing Role.
 */
@Service
@Transactional
public class RoleServiceImpl implements RoleService{

    private final Logger log = LoggerFactory.getLogger(RoleServiceImpl.class);

    private final RoleRepository roleRepository;

    private final RoleMapper roleMapper;

    public RoleServiceImpl(RoleRepository roleRepository, RoleMapper roleMapper) {
        this.roleRepository = roleRepository;
        this.roleMapper = roleMapper;
    }

    /**
     * Save a role.
     *
     * @param roleDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public RoleDTO save(RoleDTO roleDTO) {
        log.debug("Request to save Role : {}", roleDTO);
        Role role = roleMapper.toEntity(roleDTO);
        role = roleRepository.save(role);
        RoleDTO result = roleMapper.toDto(role);
        return result;
    }

    /**
     *  Get all the roles.
     *
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<RoleDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Roles");
        Role roleReq = new Role();
        roleReq.setParentId(0L);

        //创建匹配器，即如何使用查询条件
       /* ExampleMatcher matcher = ExampleMatcher.matching() //构建对象
            .withMatcher("name", ExampleMatcher.GenericPropertyMatchers.startsWith()) //姓名采用“开始匹配”的方式查询
            .withIgnorePaths("focus"); */ //忽略属性：是否关注。因为是基本类型，需要忽略掉

        //创建实例
        Example<Role> ex = Example.of(roleReq);

        Page<Role> result = roleRepository.findAll(ex,pageable);
        return result.map(role -> roleMapper.toDto(role));
    }

    /**
     *  Get one role by id.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public RoleDTO findOne(Long id) {
        log.debug("Request to get Role : {}", id);
        Role role = roleRepository.findOne(id);
        RoleDTO roleDTO = roleMapper.toDto(role);
        return roleDTO;
    }

    /**
     *  Delete the  role by id.
     *
     *  @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Role : {}", id);
        roleRepository.delete(id);
    }
}
