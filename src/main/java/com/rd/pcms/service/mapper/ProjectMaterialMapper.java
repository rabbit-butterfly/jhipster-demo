package com.rd.pcms.service.mapper;

import com.rd.pcms.domain.*;
import com.rd.pcms.service.dto.ProjectMaterialDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity ProjectMaterial and its DTO ProjectMaterialDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface ProjectMaterialMapper extends EntityMapper <ProjectMaterialDTO, ProjectMaterial> {
    
    
    /**
     * generating the fromId for all mappers if the databaseType is sql, as the class has relationship to it might need it, instead of
     * creating a new attribute to know if the entity has any relationship from some other entity
     *
     * @param id id of the entity
     * @return the entity instance
     */
     
    default ProjectMaterial fromId(Long id) {
        if (id == null) {
            return null;
        }
        ProjectMaterial projectMaterial = new ProjectMaterial();
        projectMaterial.setId(id);
        return projectMaterial;
    }
}
