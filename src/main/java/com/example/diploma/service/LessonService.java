package com.example.diploma.service;

import com.example.diploma.entity.Lesson;
import java.util.List;
import java.util.UUID;

public interface LessonService {

  List<Lesson> getAllLessons();

  Lesson getCurrentLesson(UUID lessonId);

  List<Lesson> getCurrentLessonFuture(String day);

  List<Lesson> getCurrentLessonPast(String day);

  Lesson addLesson(Lesson lesson);

  Lesson editLesson(Lesson lesson);
}
