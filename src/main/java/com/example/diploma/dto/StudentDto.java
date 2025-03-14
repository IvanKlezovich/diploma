package com.example.diploma.dto;

import java.util.UUID;

public record StudentDto(
    UUID studentId,
    String name,
    String secondName
) {

}
