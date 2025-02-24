package com.example.diploma.service.impl;

import com.example.diploma.entity.Lesson;
import com.example.diploma.repository.LessonRepository;
import com.example.diploma.service.LessonService;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LessonServiceImpl implements LessonService {

  private final LessonRepository lessonRepository;

  @Override
  public List<Lesson> getAllLessons() {
    return lessonRepository.findAll();
  }

  @Override
  public Lesson getCurrentLesson(UUID lessonId) {
    return lessonRepository.findById(lessonId)
        .orElse(null);
  }

  @Override
  public List<Lesson> getCurrentLessonFuture(String day) {
    return List.of();
  }

  @Override
  public List<Lesson> getCurrentLessonPast(String day) {
    return List.of();
  }

  @Override
  public Lesson addLesson(Lesson lesson) {
    return lessonRepository.save(lesson);
  }

  @Override
  public Lesson editLesson(Lesson lesson) {
    return lessonRepository.save(lesson);
  }
}
