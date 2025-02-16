package com.example.diploma.service.impl;

import com.example.diploma.dto.DayOfWeekDto;
import com.example.diploma.entity.Schedules;
import com.example.diploma.repository.DairyRepository;
import com.example.diploma.service.DairyService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@RequiredArgsConstructor
public class DairyServiceImpl implements DairyService {

    private DairyRepository dairyRepository;

    @Transactional
    public DayOfWeekDto getDayOfWeekByName(String day) {
        Schedules dayOfWeek = dairyRepository.getSchedulesByDays(day);
        return DayOfWeekDto.builder()
            .name(dayOfWeek.getDays())
            .formName(dayOfWeek.getForm())
            .lessons(dayOfWeek.getLesson())
            .startTime(dayOfWeek.getStartTime())
            .build();
    }
}
