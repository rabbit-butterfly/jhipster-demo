package com.jumore.zhxf.service.mapper;

import com.jumore.zhxf.domain.*;
import com.jumore.zhxf.service.dto.NewsDTO;

import org.mapstruct.*;
import java.util.List;

/**
 * Mapper for the entity News and its DTO NewsDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface NewsMapper {

    NewsDTO newsToNewsDTO(News news);

    List<NewsDTO> newsToNewsDTOs(List<News> news);

    News newsDTOToNews(NewsDTO newsDTO);

    List<News> newsDTOsToNews(List<NewsDTO> newsDTOs);
}
