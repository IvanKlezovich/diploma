package com.example.diploma.service.impl;

import com.example.diploma.entity.Student;
import com.example.diploma.repository.StudentRepository;
import com.example.diploma.service.StudentService;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

  private final StudentRepository studentRepository;

  public Student addStudent(Student student) {
    return studentRepository.save(student);
  }

  public Student getStudent(UUID studentId) {
    return studentRepository.findById(studentId)
        .orElse(null);
  }

  @Override
  public List<Student> findAll() {
    return studentRepository.findAll();
  }
}
