package com.example.diploma.dto.scheduler;

import java.time.LocalTime;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LessonPeriod {

  LocalTime startTime;
  LocalTime endTime;
}
