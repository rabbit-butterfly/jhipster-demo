package com.rd.pcms.service.mapper;

import com.rd.pcms.domain.*;
import com.rd.pcms.service.dto.UserPowerDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity UserPower and its DTO UserPowerDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface UserPowerMapper extends EntityMapper <UserPowerDTO, UserPower> {
    
    
    /**
     * generating the fromId for all mappers if the databaseType is sql, as the class has relationship to it might need it, instead of
     * creating a new attribute to know if the entity has any relationship from some other entity
     *
     * @param id id of the entity
     * @return the entity instance
     */
     
    default UserPower fromId(Long id) {
        if (id == null) {
            return null;
        }
        UserPower userPower = new UserPower();
        userPower.setId(id);
        return userPower;
    }
}
