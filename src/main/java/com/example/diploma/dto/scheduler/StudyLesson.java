package com.example.diploma.dto.scheduler;

import com.example.diploma.entity.Lesson;
import lombok.Builder;

@Builder
public class StudyLesson {

  private Lesson lesson;
  private LessonPeriod time;
}
