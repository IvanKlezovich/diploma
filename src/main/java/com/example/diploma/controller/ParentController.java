package com.example.diploma.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/parent")
@RequiredArgsConstructor
public class ParentController {

//  private final ParentService parentService;

  @RequestMapping("/")
  public String index() {
    return "parent/index";
  }

  @RequestMapping("/events")
  public String events() {
    return "parent/events";
  }

  @RequestMapping("/grades")
  public String grades() {
    return "parent/grades";
  }

  @RequestMapping("/homework")
  public String homework() {
    return "parent/homework";
  }

  @RequestMapping("/materials")
  public String materials() {
    return "parent/materials";
  }

  @RequestMapping("/notes")
  public String notes() {
    return "parent/notes";
  }
}
