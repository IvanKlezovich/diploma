package com.example.diploma.service;

import com.example.diploma.dto.SchedulesDto;
import java.util.List;
import java.util.UUID;

public interface SchedulerService {

  List<SchedulesDto> getAllSchedulers(UUID formId);

  SchedulesDto getSchedulerById(UUID id, String day);

  SchedulesDto saveScheduler(SchedulesDto schedulerDto);
}
