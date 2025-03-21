package com.example.diploma.dto;

import java.time.LocalTime;
import java.util.UUID;

public record CreateScheduler(
    UUID lessonId,
    UUID classId,
    String apartament,
    LocalTime startTime,
    LocalTime endTime) {

}