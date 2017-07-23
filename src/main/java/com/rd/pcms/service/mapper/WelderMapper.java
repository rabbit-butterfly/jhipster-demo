package com.rd.pcms.service.mapper;

import com.rd.pcms.domain.*;
import com.rd.pcms.service.dto.WelderDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Welder and its DTO WelderDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface WelderMapper extends EntityMapper <WelderDTO, Welder> {
    
    
    /**
     * generating the fromId for all mappers if the databaseType is sql, as the class has relationship to it might need it, instead of
     * creating a new attribute to know if the entity has any relationship from some other entity
     *
     * @param id id of the entity
     * @return the entity instance
     */
     
    default Welder fromId(Long id) {
        if (id == null) {
            return null;
        }
        Welder welder = new Welder();
        welder.setId(id);
        return welder;
    }
}
