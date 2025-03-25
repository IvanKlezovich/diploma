package com.example.diploma.dto;

import java.time.LocalTime;
import java.util.UUID;

public record CreateScheduler(
    UUID lessonId,
    UUID classId,
    String apartment,
    LocalTime startTime,
    LocalTime endTime,
    String dayOfWeek) {

}