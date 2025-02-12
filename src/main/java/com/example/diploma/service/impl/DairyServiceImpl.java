package com.example.diploma.service.impl;

import com.example.diploma.dto.DayOfWeekDto;
import com.example.diploma.entity.DayOfWeek;
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
        DayOfWeek dayOfWeek = dairyRepository.getDayOfWeekByName(day);
        return DayOfWeekDto.builder()
            .name(dayOfWeek.getName())
            .className(dayOfWeek.getClassName())
            .lessons(dayOfWeek.getLessons())
            .build();
    }

    @Transactional
    public DayOfWeekDto saveDayOfWeek(DayOfWeekDto day) {
        DayOfWeek dayOfWeek = dairyRepository.save(new DayOfWeek(day.name(), day.className(), day.lessons()));
        return DayOfWeekDto.builder()
            .name(dayOfWeek.getName())
            .className(dayOfWeek.getClassName())
            .lessons(dayOfWeek.getLessons())
            .build();
    }
}
