package com.example.diploma.service.impl;

import com.example.diploma.entity.Teacher;
import com.example.diploma.repository.TeacherRepository;
import com.example.diploma.service.TeacherService;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TeacherServiceImpl implements TeacherService {

  private final TeacherRepository teacherRepository;

  public Teacher addTeacher(Teacher teacher) {
    return teacherRepository.save(teacher);
  }

  @Override
  public List<Teacher> getAllTeachers() {
    return teacherRepository.findAll();
  }

  @Override
  public Teacher getTeacherByName(String firstname, String lastname, String surname) {
    return teacherRepository.getTeacherByFirstnameAndLastnameAndSurname(firstname, lastname,
        surname);
  }

  @Override
  public Teacher getTeacherById(UUID teacherId) {
    return teacherRepository.findById(teacherId)
        .orElse(null);
  }
}
