package com.example.diploma.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.time.LocalDate;

public record CreateUserDto(String login,
                            String email,
                            String firstname,
                            String surname,
                            String lastname,
                            String phone,
                            String role,
                            @JsonInclude(JsonInclude.Include.NON_NULL)
                            String job,
                            @JsonInclude(JsonInclude.Include.NON_NULL)
                            String description,
                            LocalDate timeLimit) {

}
