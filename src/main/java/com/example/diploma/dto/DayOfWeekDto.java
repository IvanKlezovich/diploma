package com.example.diploma.dto;

import com.example.diploma.entity.Class;
import com.example.diploma.entity.Day;
import com.example.diploma.entity.Lesson;

import java.util.List;
import lombok.Builder;

@Builder
public record DayOfWeekDto(
        Day name,
        List<Class> className,
        List<Lesson> lessons) {

}
