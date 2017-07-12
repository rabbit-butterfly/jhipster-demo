package com.jumore.zhxf.service.mapper;

import com.jumore.zhxf.domain.*;
import com.jumore.zhxf.service.dto.ReportCountDTO;

import org.mapstruct.*;
import java.util.List;

/**
 * Mapper for the entity ReportCount and its DTO ReportCountDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface ReportCountMapper {

    ReportCountDTO reportCountToReportCountDTO(ReportCount reportCount);

    List<ReportCountDTO> reportCountsToReportCountDTOs(List<ReportCount> reportCounts);

    ReportCount reportCountDTOToReportCount(ReportCountDTO reportCountDTO);

    List<ReportCount> reportCountDTOsToReportCounts(List<ReportCountDTO> reportCountDTOs);
}
