package com.rd.pcms.service.mapper;

import com.rd.pcms.domain.*;
import com.rd.pcms.service.dto.PpInspectionRuleDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity PpInspectionRule and its DTO PpInspectionRuleDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface PpInspectionRuleMapper extends EntityMapper <PpInspectionRuleDTO, PpInspectionRule> {
    
    
    /**
     * generating the fromId for all mappers if the databaseType is sql, as the class has relationship to it might need it, instead of
     * creating a new attribute to know if the entity has any relationship from some other entity
     *
     * @param id id of the entity
     * @return the entity instance
     */
     
    default PpInspectionRule fromId(Long id) {
        if (id == null) {
            return null;
        }
        PpInspectionRule ppInspectionRule = new PpInspectionRule();
        ppInspectionRule.setId(id);
        return ppInspectionRule;
    }
}
