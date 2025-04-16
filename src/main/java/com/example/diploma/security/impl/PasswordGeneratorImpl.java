package com.example.diploma.security.impl;

import com.example.diploma.security.PasswordGenerator;
import java.security.SecureRandom;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PasswordGeneratorImpl implements PasswordGenerator {

  private final SecureRandom rnd;

  @Value("${app.password.length}")
  private int passwordLength;

  @Value("${app.password.symbols}")
  private String symbols;


  public char[] getPassword() {
    return randomPass();
  }

  private char[] randomPass() {
    StringBuilder pass = new StringBuilder(passwordLength);
    for (int i = 0; i < passwordLength; i++) {
      pass.append(symbols.charAt(rnd.nextInt(symbols.length())));
    }
    return pass.toString().toCharArray();
  }
}
