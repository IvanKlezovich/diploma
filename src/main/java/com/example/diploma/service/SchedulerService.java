package com.example.diploma.service;

import com.example.diploma.dto.CreateScheduler;
import com.example.diploma.dto.SchedulesDto;
import com.example.diploma.entity.Schedules;
import java.util.List;
import java.util.UUID;

public interface SchedulerService {

  List<SchedulesDto> getAllSchedulers(UUID formId);

  SchedulesDto getSchedulerById(UUID id, String day);

  SchedulesDto saveScheduler(Schedules schedules);
}
