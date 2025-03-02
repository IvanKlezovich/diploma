//package com.example.diploma.controller;
//
//import com.example.diploma.entity.Parent;
//import com.example.diploma.entity.Student;
//import com.example.diploma.service.ParentService;
//import java.util.List;
//import java.util.UUID;
//import lombok.RequiredArgsConstructor;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/parent")
//@RequiredArgsConstructor
//public class ParentController {
//
//  private final ParentService parentService;
//
//  @GetMapping("/{studentId}")
//  public List<Parent> getParent(@PathVariable UUID studentId) {
//    return null;
//  }
//
//  @GetMapping("/children/{parentId}")
//  public List<Student> getChildren(@PathVariable UUID parentId) {
//    return null;
//  }
//
//  @DeleteMapping("/delete")
//  public void deleteParent(@PathVariable UUID parentId) {
//
//  }
//
//  @PostMapping("/add/children")
//  public Parent addChildren(Student student) {
//    return null;
//  }
//}
