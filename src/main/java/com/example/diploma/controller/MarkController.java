package com.example.diploma.controller;

import com.example.diploma.entity.Mark;
import com.example.diploma.service.MarkService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mark")
@RequiredArgsConstructor
public class MarkController {

  private MarkService markService;

  @PostMapping("/add")
  public void addMark(Mark mark) {
    markService.addMark(mark);
  }

  @PatchMapping("/change")
  public void editMark(Mark mark) {
    markService.editMark(mark);
  }
}
