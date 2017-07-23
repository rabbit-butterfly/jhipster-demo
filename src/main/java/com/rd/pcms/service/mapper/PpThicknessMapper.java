package com.rd.pcms.service.mapper;

import com.rd.pcms.domain.*;
import com.rd.pcms.service.dto.PpThicknessDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity PpThickness and its DTO PpThicknessDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface PpThicknessMapper extends EntityMapper <PpThicknessDTO, PpThickness> {
    
    
    /**
     * generating the fromId for all mappers if the databaseType is sql, as the class has relationship to it might need it, instead of
     * creating a new attribute to know if the entity has any relationship from some other entity
     *
     * @param id id of the entity
     * @return the entity instance
     */
     
    default PpThickness fromId(Long id) {
        if (id == null) {
            return null;
        }
        PpThickness ppThickness = new PpThickness();
        ppThickness.setId(id);
        return ppThickness;
    }
}
