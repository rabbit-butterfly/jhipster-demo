package com.rd.pcms.service.mapper;

import com.rd.pcms.domain.*;
import com.rd.pcms.service.dto.BizAuthDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity BizAuth and its DTO BizAuthDTO.
 */
@Mapper(componentModel = "spring", uses = {BizMapper.class, })
public interface BizAuthMapper extends EntityMapper <BizAuthDTO, BizAuth> {
    @Mapping(source = "biz.id", target = "bizId")
    @Mapping(source = "biz.bizName", target = "bizBizName")
    BizAuthDTO toDto(BizAuth bizAuth); 
    @Mapping(source = "bizId", target = "biz")
    @Mapping(target = "role", ignore = true)
    BizAuth toEntity(BizAuthDTO bizAuthDTO); 
    /**
     * generating the fromId for all mappers if the databaseType is sql, as the class has relationship to it might need it, instead of
     * creating a new attribute to know if the entity has any relationship from some other entity
     *
     * @param id id of the entity
     * @return the entity instance
     */
     
    default BizAuth fromId(Long id) {
        if (id == null) {
            return null;
        }
        BizAuth bizAuth = new BizAuth();
        bizAuth.setId(id);
        return bizAuth;
    }
}
