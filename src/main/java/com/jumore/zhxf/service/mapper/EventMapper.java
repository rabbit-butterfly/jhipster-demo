package com.jumore.zhxf.service.mapper;

import com.jumore.zhxf.domain.*;
import com.jumore.zhxf.service.dto.EventDTO;

import org.mapstruct.*;
import java.util.List;

/**
 * Mapper for the entity Event and its DTO EventDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface EventMapper {

    EventDTO eventToEventDTO(Event event);

    List<EventDTO> eventsToEventDTOs(List<Event> events);

    Event eventDTOToEvent(EventDTO eventDTO);

    List<Event> eventDTOsToEvents(List<EventDTO> eventDTOs);
}
