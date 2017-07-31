package com.rd.pcms.service.mapper;

import com.rd.pcms.domain.*;
import com.rd.pcms.service.dto.BizDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Biz and its DTO BizDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface BizMapper extends EntityMapper <BizDTO, Biz> {
    
    
    /**
     * generating the fromId for all mappers if the databaseType is sql, as the class has relationship to it might need it, instead of
     * creating a new attribute to know if the entity has any relationship from some other entity
     *
     * @param id id of the entity
     * @return the entity instance
     */
     
    default Biz fromId(Long id) {
        if (id == null) {
            return null;
        }
        Biz biz = new Biz();
        biz.setId(id);
        return biz;
    }
}
