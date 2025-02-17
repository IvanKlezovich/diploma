package com.example.diploma.dto;

import com.example.diploma.entity.Day;
import com.example.diploma.entity.Form;
import com.example.diploma.entity.Lesson;
import java.time.LocalDateTime;
import java.util.List;

public class SchedulesDto {

  private Form form;

  private List<Lesson> lesson;

  private LocalDateTime startTime;

  private Day dayOfWeek;

}
