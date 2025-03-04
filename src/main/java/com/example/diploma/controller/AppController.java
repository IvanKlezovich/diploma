package com.example.diploma.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
public class AppController {

  @RequestMapping("/login")
  public String login() {
    return "login";
  }

  @RequestMapping("/feedback")
  public String feedback() {
    return "feedback";
  }
}
