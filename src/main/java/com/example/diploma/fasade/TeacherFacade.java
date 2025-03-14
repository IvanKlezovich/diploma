package com.example.diploma.fasade;

import com.example.diploma.dto.CreateGradeDto;
import com.example.diploma.entity.Mark;
import com.example.diploma.service.LessonService;
import com.example.diploma.service.MarkService;
import com.example.diploma.service.StudentService;
import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class TeacherFacade {

  private final MarkService markService;
  private final StudentService studentService;
  private final LessonService lessonService;

  public void addMark(CreateGradeDto createGradeDto) {
    markService.addMark(new Mark(createGradeDto.mark(),
        studentService.getStudent(createGradeDto.studentId()),
        lessonService.getCurrentLesson(createGradeDto.lessonId()),
        LocalDateTime.now()));
  }
}
