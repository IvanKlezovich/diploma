package com.example.diploma.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {

  @RequestMapping("/")
  public String index() {
    return "admin/index";
  }

  @RequestMapping("/users")
  public String user() {
    return "admin/users";
  }

  @RequestMapping("/content")
  public String content() {
    return "admin/content";
  }

  @RequestMapping("/roles")
  public String roles() {
    return "admin/roles";
  }

  @RequestMapping("/classes")
  public String form() {
    return "admin/classes";
  }
}
