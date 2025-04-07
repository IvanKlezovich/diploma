package com.example.diploma.service;

import com.example.diploma.dto.scheduler.SchedulesDto;
import com.example.diploma.entity.Schedules;
import java.util.List;
import java.util.UUID;

public interface SchedulerService {

  List<Schedules> getAllSchedulers();

  List<SchedulesDto> getAllSchedulersByFormId(UUID formId);

  SchedulesDto getSchedulerById(UUID id, String day);

  SchedulesDto saveScheduler(Schedules schedules);
}
