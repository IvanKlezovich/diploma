package com.example.diploma.exceptions.base;

import java.util.Locale;
import java.util.Map;
import java.util.Optional;

public interface ServiceException {

    Map<Locale, String> getMessages();

    Optional<Integer> getHttpCode();

    Map<String, String> getParams();

}
