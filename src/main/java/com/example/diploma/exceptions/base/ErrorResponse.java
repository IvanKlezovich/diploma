package com.example.diploma.exceptions.base;

import java.time.ZonedDateTime;
import java.util.Map;

public record ErrorResponse(

    String errorCode,
    String message,
    Map<String, String> params,
    ZonedDateTime nowUTC) {

}
