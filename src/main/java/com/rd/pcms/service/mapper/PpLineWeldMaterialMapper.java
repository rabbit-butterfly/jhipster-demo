package com.rd.pcms.service.mapper;

import com.rd.pcms.domain.*;
import com.rd.pcms.service.dto.PpLineWeldMaterialDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity PpLineWeldMaterial and its DTO PpLineWeldMaterialDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface PpLineWeldMaterialMapper extends EntityMapper <PpLineWeldMaterialDTO, PpLineWeldMaterial> {
    
    
    /**
     * generating the fromId for all mappers if the databaseType is sql, as the class has relationship to it might need it, instead of
     * creating a new attribute to know if the entity has any relationship from some other entity
     *
     * @param id id of the entity
     * @return the entity instance
     */
     
    default PpLineWeldMaterial fromId(Long id) {
        if (id == null) {
            return null;
        }
        PpLineWeldMaterial ppLineWeldMaterial = new PpLineWeldMaterial();
        ppLineWeldMaterial.setId(id);
        return ppLineWeldMaterial;
    }
}
