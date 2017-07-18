package com.rd.pcms.service.mapper;

import com.rd.pcms.domain.*;
import com.rd.pcms.service.dto.ProjectWelderDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity ProjectWelder and its DTO ProjectWelderDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface ProjectWelderMapper extends EntityMapper <ProjectWelderDTO, ProjectWelder> {
    
    
    /**
     * generating the fromId for all mappers if the databaseType is sql, as the class has relationship to it might need it, instead of
     * creating a new attribute to know if the entity has any relationship from some other entity
     *
     * @param id id of the entity
     * @return the entity instance
     */
     
    default ProjectWelder fromId(Long id) {
        if (id == null) {
            return null;
        }
        ProjectWelder projectWelder = new ProjectWelder();
        projectWelder.setId(id);
        return projectWelder;
    }
}
