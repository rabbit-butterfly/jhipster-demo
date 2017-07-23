package com.rd.pcms.service.mapper;

import com.rd.pcms.domain.*;
import com.rd.pcms.service.dto.UserAreaDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity UserArea and its DTO UserAreaDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface UserAreaMapper extends EntityMapper <UserAreaDTO, UserArea> {
    
    
    /**
     * generating the fromId for all mappers if the databaseType is sql, as the class has relationship to it might need it, instead of
     * creating a new attribute to know if the entity has any relationship from some other entity
     *
     * @param id id of the entity
     * @return the entity instance
     */
     
    default UserArea fromId(Long id) {
        if (id == null) {
            return null;
        }
        UserArea userArea = new UserArea();
        userArea.setId(id);
        return userArea;
    }
}
