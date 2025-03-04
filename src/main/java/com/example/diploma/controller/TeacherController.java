package com.example.diploma.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/teacher")
@RequiredArgsConstructor
public class TeacherController {

  @RequestMapping("/grades")
  public String grades() {
    return "teacher/grades";
  }

  @RequestMapping("/homework")
  public String homework() {
    return "teacher/homework";
  }

  @RequestMapping("/materials")
  public String materials() {
    return "teacher/materials";
  }

  @RequestMapping("/notes")
  public String notes() {
    return "teacher/notes";
  }

  @RequestMapping("/events")
  public String teacher() {
    return "teacher/event";
  }

  @RequestMapping("/")
  public String index() {
    return "teacher/index";
  }
}
