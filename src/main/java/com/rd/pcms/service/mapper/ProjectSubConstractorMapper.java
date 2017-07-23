package com.rd.pcms.service.mapper;

import com.rd.pcms.domain.*;
import com.rd.pcms.service.dto.ProjectSubConstractorDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity ProjectSubConstractor and its DTO ProjectSubConstractorDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface ProjectSubConstractorMapper extends EntityMapper <ProjectSubConstractorDTO, ProjectSubConstractor> {
    
    
    /**
     * generating the fromId for all mappers if the databaseType is sql, as the class has relationship to it might need it, instead of
     * creating a new attribute to know if the entity has any relationship from some other entity
     *
     * @param id id of the entity
     * @return the entity instance
     */
     
    default ProjectSubConstractor fromId(Long id) {
        if (id == null) {
            return null;
        }
        ProjectSubConstractor projectSubConstractor = new ProjectSubConstractor();
        projectSubConstractor.setId(id);
        return projectSubConstractor;
    }
}
