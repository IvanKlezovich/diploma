package com.example.diploma.controller;

import com.example.diploma.entity.Lesson;
import com.example.diploma.service.LessonService;
import java.util.List;
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
@RequestMapping("/lessons")
@RequiredArgsConstructor
public class LessonController {

  private LessonService lessonService;

  @GetMapping("/all")
  public List<Lesson> getAllLessons() {
    return lessonService.getAllLessons();
  }

  @GetMapping("/current/{lessonId}")
  public Lesson getCurrentLesson(@PathVariable UUID lessonId) {
    return lessonService.getCurrentLesson(lessonId);
  }

  @GetMapping("/current/future/{day}")
  public List<Lesson> getCurrentLessonFuture(@PathVariable String day) {
    return lessonService.getCurrentLessonFuture(day);
  }

  @GetMapping("/current/past/{day}")
  public List<Lesson> getCurrentLessonPast(@PathVariable String day) {
    return lessonService.getCurrentLessonPast(day);
  }

  @PostMapping("/add")
  public Lesson addLesson(@RequestBody Lesson lesson) {
    return lessonService.addLesson(lesson);
  }

  @PatchMapping("/edit")
  public Lesson editLesson(@RequestBody Lesson lesson) {
    return lessonService.editLesson(lesson);
  }
}
