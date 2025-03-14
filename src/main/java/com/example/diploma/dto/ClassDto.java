package com.example.diploma.dto;

import java.util.UUID;

public record ClassDto(
    UUID classId,
    String classname,
    String teacherName
) {

}
