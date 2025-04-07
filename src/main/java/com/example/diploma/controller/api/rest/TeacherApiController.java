package com.example.diploma.controller.api.rest;

import com.example.diploma.dto.CreateGradeDto;
import com.example.diploma.fasade.TeacherFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teacher")
@RequiredArgsConstructor
public class TeacherApiController {

  private final TeacherFacade teacherFacade;

  @PostMapping("/grades/add")
  public ResponseEntity<Void> addGrade(CreateGradeDto createGradeDto) {
    teacherFacade.addMark(createGradeDto);
    return ResponseEntity.ok().body(null);
  }
}
