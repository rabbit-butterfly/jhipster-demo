package com.rd.pcms.service.mapper;

import com.rd.pcms.domain.*;
import com.rd.pcms.service.dto.PpLineDrawingDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity PpLineDrawing and its DTO PpLineDrawingDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface PpLineDrawingMapper extends EntityMapper <PpLineDrawingDTO, PpLineDrawing> {
    
    
    /**
     * generating the fromId for all mappers if the databaseType is sql, as the class has relationship to it might need it, instead of
     * creating a new attribute to know if the entity has any relationship from some other entity
     *
     * @param id id of the entity
     * @return the entity instance
     */
     
    default PpLineDrawing fromId(Long id) {
        if (id == null) {
            return null;
        }
        PpLineDrawing ppLineDrawing = new PpLineDrawing();
        ppLineDrawing.setId(id);
        return ppLineDrawing;
    }
}
