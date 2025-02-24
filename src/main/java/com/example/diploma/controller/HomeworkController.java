package com.example.diploma.controller;

import com.example.diploma.entity.Homework;
import com.example.diploma.service.HomeworkService;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/homework")
@RequiredArgsConstructor
public class HomeworkController {

  private final HomeworkService homeworkService;

  @PostMapping("/add")
  public Homework save(@RequestBody Homework homework) {
    return homeworkService.addHomework(homework);
  }

  @PatchMapping("/edit")
  public Homework edit(@RequestBody Homework homework) {
    return homeworkService.editHomework(homework);
  }

  @GetMapping("/homework/{homeworkId}")
  public Homework getHomework(@PathVariable UUID homeworkId) {
    return homeworkService.getHomework(homeworkId);
  }
}
