package com.example.diploma.dto;

import java.util.UUID;

public record TeacherDto(
    UUID id,
    String firstname,
    String lastname,
    String surname) {

}
