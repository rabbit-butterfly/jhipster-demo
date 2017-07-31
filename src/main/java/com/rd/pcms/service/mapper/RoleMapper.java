package com.rd.pcms.service.mapper;

import com.rd.pcms.domain.*;
import com.rd.pcms.service.dto.RoleDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Role and its DTO RoleDTO.
 */
@Mapper(componentModel = "spring", uses = {BizAuthMapper.class, })
public interface RoleMapper extends EntityMapper <RoleDTO, Role> {
    RoleDTO toDto(Role role);
    @Mapping(target = "children", ignore = true)
    Role toEntity(RoleDTO roleDTO);
    /**
     * generating the fromId for all mappers if the databaseType is sql, as the class has relationship to it might need it, instead of
     * creating a new attribute to know if the entity has any relationship from some other entity
     *
     * @param id id of the entity
     * @return the entity instance
     */

    default Role fromId(Long id) {
        if (id == null) {
            return null;
        }
        Role role = new Role();
        role.setId(id);
        return role;
    }
}
