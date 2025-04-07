package com.example.diploma.service.impl;

import com.example.diploma.dto.scheduler.SchedulesDto;
import com.example.diploma.entity.Schedules;
import com.example.diploma.mapper.SchedulerMapper;
import com.example.diploma.repository.SchedulerRepository;
import com.example.diploma.service.SchedulerService;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SchedulerServiceImpl implements SchedulerService {

  private final SchedulerRepository schedulerRepository;
  private final SchedulerMapper schedulerMapper;

  public List<Schedules> getAllSchedulers() {
    return schedulerRepository.findAll();
  }

  public List<SchedulesDto> getAllSchedulersByFormId(UUID formId) {
    return schedulerMapper.toDto(
        schedulerRepository.findAllByFormId(formId));
  }

  public SchedulesDto getSchedulerById(UUID id, String day) {
    return schedulerMapper.toDto(
        schedulerRepository.findByFormIdAndDays(id, day));
  }

  public SchedulesDto saveScheduler(Schedules schedules) {
    return schedulerMapper.toDto(schedulerRepository.save(schedules));
  }
}
