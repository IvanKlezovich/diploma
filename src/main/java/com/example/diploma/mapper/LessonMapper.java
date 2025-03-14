package com.example.diploma.mapper;

import com.example.diploma.dto.LessonDto;
import com.example.diploma.entity.Lesson;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface LessonMapper {

  @Mapping(target = "lessonId", source = "lesson.id")
  @Mapping(target = "lessonName", source = "lesson.title")
  LessonDto toLessonDto(Lesson lesson);
}
