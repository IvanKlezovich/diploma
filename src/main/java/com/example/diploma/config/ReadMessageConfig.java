package com.example.diploma.config;

import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

public class ReadMessageConfig {

  private ReadMessageConfig() {
    throw new IllegalStateException("Utility class");
  }

  public static String getLocalizedMessage(Map<Locale, String> messages) {

    Locale locale = messages.keySet().iterator().next();
    String messageKey = messages.getOrDefault(locale, messages.get(Locale.ENGLISH));

    ResourceBundle bundle = ResourceBundle.getBundle("messages", locale);
    return bundle.getString(messageKey);
  }

  public static String getMessage(String key) {
    return getLocalizedMessage(Map.of(Locale.of("ru"), key));
  }
}
