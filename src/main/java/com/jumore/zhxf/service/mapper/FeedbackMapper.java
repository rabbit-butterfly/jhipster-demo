package com.jumore.zhxf.service.mapper;

import com.jumore.zhxf.domain.*;
import com.jumore.zhxf.service.dto.FeedbackDTO;

import org.mapstruct.*;
import java.util.List;

/**
 * Mapper for the entity Feedback and its DTO FeedbackDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface FeedbackMapper {

    FeedbackDTO feedbackToFeedbackDTO(Feedback feedback);

    List<FeedbackDTO> feedbacksToFeedbackDTOs(List<Feedback> feedbacks);

    Feedback feedbackDTOToFeedback(FeedbackDTO feedbackDTO);

    List<Feedback> feedbackDTOsToFeedbacks(List<FeedbackDTO> feedbackDTOs);
}
