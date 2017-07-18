package com.rd.pcms.service.mapper;

import com.rd.pcms.domain.*;
import com.rd.pcms.service.dto.ProjectUserDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity ProjectUser and its DTO ProjectUserDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface ProjectUserMapper extends EntityMapper <ProjectUserDTO, ProjectUser> {
    
    
    /**
     * generating the fromId for all mappers if the databaseType is sql, as the class has relationship to it might need it, instead of
     * creating a new attribute to know if the entity has any relationship from some other entity
     *
     * @param id id of the entity
     * @return the entity instance
     */
     
    default ProjectUser fromId(Long id) {
        if (id == null) {
            return null;
        }
        ProjectUser projectUser = new ProjectUser();
        projectUser.setId(id);
        return projectUser;
    }
}
