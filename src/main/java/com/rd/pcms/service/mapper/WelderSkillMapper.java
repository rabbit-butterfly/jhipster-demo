package com.rd.pcms.service.mapper;

import com.rd.pcms.domain.*;
import com.rd.pcms.service.dto.WelderSkillDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity WelderSkill and its DTO WelderSkillDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface WelderSkillMapper extends EntityMapper <WelderSkillDTO, WelderSkill> {
    
    
    /**
     * generating the fromId for all mappers if the databaseType is sql, as the class has relationship to it might need it, instead of
     * creating a new attribute to know if the entity has any relationship from some other entity
     *
     * @param id id of the entity
     * @return the entity instance
     */
     
    default WelderSkill fromId(Long id) {
        if (id == null) {
            return null;
        }
        WelderSkill welderSkill = new WelderSkill();
        welderSkill.setId(id);
        return welderSkill;
    }
}
