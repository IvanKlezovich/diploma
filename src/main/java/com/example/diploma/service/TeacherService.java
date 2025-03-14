package com.example.diploma.service;

import com.example.diploma.entity.Teacher;
import java.util.List;
import java.util.UUID;

public interface TeacherService {

  Teacher addTeacher(Teacher teacher);

  List<Teacher> getAllTeachers();

  Teacher getTeacherByName(String firstname, String lastname, String surname);

  Teacher getTeacherById(UUID teacherId);
}
