package com.example.diploma.service;

import com.example.diploma.entity.Student;
import java.util.List;
import java.util.UUID;

public interface StudentService {

  Student addStudent(Student student);

  Student getStudent(UUID id);

  List<Student> findAll();
}
