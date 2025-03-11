package com.example.diploma.service.impl;

import com.example.diploma.entity.Teacher;
import com.example.diploma.repository.TeacherRepository;
import com.example.diploma.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TeacherServiceImpl implements TeacherService {

  private final TeacherRepository teacherRepository;

  public Teacher addTeacher(Teacher teacher) {
    return teacherRepository.save(teacher);
  }
}
