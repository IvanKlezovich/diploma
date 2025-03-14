package com.example.diploma.dto;

import java.util.UUID;

public record CreateGradeDto(
    UUID studentId,
    short mark,
    UUID lessonId) {

}
