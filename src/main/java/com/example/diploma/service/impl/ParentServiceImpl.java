//package com.example.diploma.service.impl;
//
//import com.example.diploma.entity.Parent;
//import com.example.diploma.entity.Student;
//import com.example.diploma.repository.ParentRepository;
//import com.example.diploma.repository.StudentRepository;
//import com.example.diploma.service.ParentService;
//import java.util.List;
//import java.util.UUID;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//
//@Service
//@RequiredArgsConstructor
//public class ParentServiceImpl implements ParentService {
//
//  private final ParentRepository parentRepository;
//  private final StudentRepository studentRepository;
//
//  @Override
//  public List<Parent> getParent(UUID studentId) {
//    return studentRepository.findAllParentById(studentId)
//        .orElse(null);
//  }
//
//  @Override
//  public void deleteParent(UUID parentId) {
//    return parentRepository.deleteById(parentId);
//  }
//
//  @Override
//  public Parent addChildren(Student student) {
//    return parentRepository.save();
//  }
//}
