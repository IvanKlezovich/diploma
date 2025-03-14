package com.example.diploma.dto;

import java.util.UUID;

public record FormDto(
    UUID id,
    String classname,
    TeacherDto teacher
) {

}
