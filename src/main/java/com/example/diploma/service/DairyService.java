package com.example.diploma.service;

import com.example.diploma.dto.DayOfWeekDto;

public interface DairyService {

  DayOfWeekDto getDayOfWeekByName(String dayOfWeek);

  DayOfWeekDto saveDayOfWeek(DayOfWeekDto day);
}
