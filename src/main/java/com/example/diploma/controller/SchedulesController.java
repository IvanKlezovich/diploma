package com.example.diploma.controller;


import com.example.diploma.dto.SchedulesDto;
import com.example.diploma.service.SchedulerService;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/schedules")
@RequiredArgsConstructor
public class SchedulesController {

  private final SchedulerService scheduleService;

  @GetMapping("/all")
  public List<SchedulesDto> getAllSchedules(UUID formId) {
    return scheduleService.getAllSchedulers(formId);
  }

  @GetMapping("/current")
  public SchedulesDto getCurrentDay(UUID formId, String day) {
    return scheduleService.getSchedulerById(formId, day);
  }
}
