package com.example.diploma.controller;

import com.example.diploma.fasade.AdminFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {

  private final AdminFacade adminFacade;

  @RequestMapping("/")
  public String index() {
    return "admin/index";
  }

  @GetMapping("/users")
  public String user(Model model) {
    model.addAttribute("users", adminFacade.getAllUsers());
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