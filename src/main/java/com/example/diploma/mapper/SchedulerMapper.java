package com.example.diploma.mapper;

import com.example.diploma.dto.scheduler.SchedulesDto;
import com.example.diploma.entity.Schedules;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SchedulerMapper {

  SchedulesDto toDto(Schedules schedules);

  List<SchedulesDto> toDto(List<Schedules> schedules);

  List<Schedules> toEntity(List<SchedulesDto> schedulesDto);
}
