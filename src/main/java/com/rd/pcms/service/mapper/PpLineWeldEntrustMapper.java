package com.rd.pcms.service.mapper;

import com.rd.pcms.domain.*;
import com.rd.pcms.service.dto.PpLineWeldEntrustDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity PpLineWeldEntrust and its DTO PpLineWeldEntrustDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface PpLineWeldEntrustMapper extends EntityMapper <PpLineWeldEntrustDTO, PpLineWeldEntrust> {
    
    
    /**
     * generating the fromId for all mappers if the databaseType is sql, as the class has relationship to it might need it, instead of
     * creating a new attribute to know if the entity has any relationship from some other entity
     *
     * @param id id of the entity
     * @return the entity instance
     */
     
    default PpLineWeldEntrust fromId(Long id) {
        if (id == null) {
            return null;
        }
        PpLineWeldEntrust ppLineWeldEntrust = new PpLineWeldEntrust();
        ppLineWeldEntrust.setId(id);
        return ppLineWeldEntrust;
    }
}
