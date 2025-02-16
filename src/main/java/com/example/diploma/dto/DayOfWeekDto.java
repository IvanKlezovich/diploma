package com.example.diploma.dto;

import com.example.diploma.entity.Day;
import com.example.diploma.entity.Form;
import com.example.diploma.entity.Lesson;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Builder;

@Builder
public record DayOfWeekDto(
    Day name,
    Form formName,
    Lesson lessons,
    LocalDateTime startTime) {

}
