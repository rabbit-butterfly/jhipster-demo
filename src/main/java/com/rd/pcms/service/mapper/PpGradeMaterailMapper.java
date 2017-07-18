package com.rd.pcms.service.mapper;

import com.rd.pcms.domain.*;
import com.rd.pcms.service.dto.PpGradeMaterailDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity PpGradeMaterail and its DTO PpGradeMaterailDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface PpGradeMaterailMapper extends EntityMapper <PpGradeMaterailDTO, PpGradeMaterail> {
    
    
    /**
     * generating the fromId for all mappers if the databaseType is sql, as the class has relationship to it might need it, instead of
     * creating a new attribute to know if the entity has any relationship from some other entity
     *
     * @param id id of the entity
     * @return the entity instance
     */
     
    default PpGradeMaterail fromId(Long id) {
        if (id == null) {
            return null;
        }
        PpGradeMaterail ppGradeMaterail = new PpGradeMaterail();
        ppGradeMaterail.setId(id);
        return ppGradeMaterail;
    }
}
