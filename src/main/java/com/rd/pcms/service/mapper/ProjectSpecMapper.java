package com.rd.pcms.service.mapper;

import com.rd.pcms.domain.*;
import com.rd.pcms.service.dto.ProjectSpecDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity ProjectSpec and its DTO ProjectSpecDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface ProjectSpecMapper extends EntityMapper <ProjectSpecDTO, ProjectSpec> {
    
    
    /**
     * generating the fromId for all mappers if the databaseType is sql, as the class has relationship to it might need it, instead of
     * creating a new attribute to know if the entity has any relationship from some other entity
     *
     * @param id id of the entity
     * @return the entity instance
     */
     
    default ProjectSpec fromId(Long id) {
        if (id == null) {
            return null;
        }
        ProjectSpec projectSpec = new ProjectSpec();
        projectSpec.setId(id);
        return projectSpec;
    }
}
