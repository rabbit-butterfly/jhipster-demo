package com.rd.pcms.service.mapper;

import com.rd.pcms.domain.*;
import com.rd.pcms.service.dto.PpLineWeldCheckDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity PpLineWeldCheck and its DTO PpLineWeldCheckDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface PpLineWeldCheckMapper extends EntityMapper <PpLineWeldCheckDTO, PpLineWeldCheck> {
    
    
    /**
     * generating the fromId for all mappers if the databaseType is sql, as the class has relationship to it might need it, instead of
     * creating a new attribute to know if the entity has any relationship from some other entity
     *
     * @param id id of the entity
     * @return the entity instance
     */
     
    default PpLineWeldCheck fromId(Long id) {
        if (id == null) {
            return null;
        }
        PpLineWeldCheck ppLineWeldCheck = new PpLineWeldCheck();
        ppLineWeldCheck.setId(id);
        return ppLineWeldCheck;
    }
}
