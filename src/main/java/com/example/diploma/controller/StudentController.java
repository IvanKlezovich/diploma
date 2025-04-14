package com.example.diploma.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentController {

  @RequestMapping("/schedules")
  public String notes() {
    return "student/schedules";
  }

  @RequestMapping("/mark")
  public String event() {
    return "student/mark";
  }

  @RequestMapping("/")
  public String index() {
    return "student/index";
  }
}