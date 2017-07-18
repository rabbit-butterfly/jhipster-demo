package com.rd.pcms.service.mapper;

import com.rd.pcms.domain.*;
import com.rd.pcms.service.dto.PpIinspectionTatioDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity PpIinspectionTatio and its DTO PpIinspectionTatioDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface PpIinspectionTatioMapper extends EntityMapper <PpIinspectionTatioDTO, PpIinspectionTatio> {
    
    
    /**
     * generating the fromId for all mappers if the databaseType is sql, as the class has relationship to it might need it, instead of
     * creating a new attribute to know if the entity has any relationship from some other entity
     *
     * @param id id of the entity
     * @return the entity instance
     */
     
    default PpIinspectionTatio fromId(Long id) {
        if (id == null) {
            return null;
        }
        PpIinspectionTatio ppIinspectionTatio = new PpIinspectionTatio();
        ppIinspectionTatio.setId(id);
        return ppIinspectionTatio;
    }
}
