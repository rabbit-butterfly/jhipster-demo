package com.rd.pcms.service.mapper;

import com.rd.pcms.domain.*;
import com.rd.pcms.service.dto.PpLineDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity PpLine and its DTO PpLineDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface PpLineMapper extends EntityMapper <PpLineDTO, PpLine> {
    
    
    /**
     * generating the fromId for all mappers if the databaseType is sql, as the class has relationship to it might need it, instead of
     * creating a new attribute to know if the entity has any relationship from some other entity
     *
     * @param id id of the entity
     * @return the entity instance
     */
     
    default PpLine fromId(Long id) {
        if (id == null) {
            return null;
        }
        PpLine ppLine = new PpLine();
        ppLine.setId(id);
        return ppLine;
    }
}
