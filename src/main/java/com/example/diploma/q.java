package com.example.diploma;

import java.security.SecureRandom;

public class q {

  private final static String symbols = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890!@$%^&*";
  private final static SecureRandom rnd = new SecureRandom();

  public static void main(String[] args) {
    for (int i = 0; i < 10; i++) {
      System.out.println(randomPass(symbols, 16));
    }
  }

  public static String randomPass(String symbols, int len) {
    StringBuilder pass = new StringBuilder(len);
    for (int i = 0; i < len; i++) {
      pass.append(symbols.charAt(rnd.nextInt(symbols.length())));
    }
    return pass.toString();
  }
}
