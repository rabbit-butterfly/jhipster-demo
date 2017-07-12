package com.jumore.zhxf.service.mapper;

import com.jumore.zhxf.domain.*;
import com.jumore.zhxf.service.dto.RegistDTO;

import org.mapstruct.*;
import java.util.List;

/**
 * Mapper for the entity Regist and its DTO RegistDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface RegistMapper {

    RegistDTO registToRegistDTO(Regist regist);

    List<RegistDTO> registsToRegistDTOs(List<Regist> regists);

    Regist registDTOToRegist(RegistDTO registDTO);

    List<Regist> registDTOsToRegists(List<RegistDTO> registDTOs);
}
