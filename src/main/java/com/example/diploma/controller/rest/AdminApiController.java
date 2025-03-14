package com.example.diploma.controller.rest;

import com.example.diploma.dto.AddStudentToFormDto;
import com.example.diploma.dto.BlockUserDto;
import com.example.diploma.dto.ClassDto;
import com.example.diploma.dto.CreateFormDto;
import com.example.diploma.dto.CreateLessonDto;
import com.example.diploma.dto.CreateUserDto;
import com.example.diploma.dto.RoleNameDto;
import com.example.diploma.dto.StudentDto;
import com.example.diploma.dto.TeacherDto;
import com.example.diploma.entity.Form;
import com.example.diploma.entity.Lesson;
import com.example.diploma.entity.User;
import com.example.diploma.fasade.AdminFacade;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminApiController {

  private final AdminFacade adminFacade;

  @PostMapping("/users/add")
  public ResponseEntity<User> addUser(CreateUserDto createUserDto) {
    User users = adminFacade.addPeople(createUserDto);
    return ResponseEntity.ok().body(users);
  }

  @PatchMapping("/users/block")
  public ResponseEntity<Void> blockUser(@RequestBody BlockUserDto userId) {
    adminFacade.blockUser(userId.userId());
    return ResponseEntity.ok().build();
  }

  @PatchMapping("/users/change/role")
  public ResponseEntity<Void> changeRoleUser(@RequestBody RoleNameDto roleNameDto) {
    adminFacade.changeRole(roleNameDto);
    return ResponseEntity.ok().build();
  }

  @DeleteMapping("/users/delete/role")
  public ResponseEntity<User> deleteUser(String userData) {
    return null;
  }

  @PatchMapping("/users/edit")
  public ResponseEntity<User> editUser(String userData) {
    return null;
  }

  @PostMapping("/lessons/add")
  public ResponseEntity<Lesson> addLesson(CreateLessonDto createLessonDto) {
    Lesson lesson = adminFacade.addLesson(createLessonDto);
    return ResponseEntity.ok().body(lesson);
  }

  @PostMapping("/class/add")
  public ResponseEntity<Form> getForm(@RequestBody CreateFormDto createFormDto) {
    Form form = adminFacade.addForm(createFormDto);
    return ResponseEntity.ok().body(form);
  }

  @PostMapping("/classes/add-student")
  public ResponseEntity<StudentDto> getStudent(
      @RequestBody AddStudentToFormDto addStudentToFormDto) {
    System.out.println(addStudentToFormDto.toString());
    return ResponseEntity.ok().body(adminFacade.addStudentToClass(addStudentToFormDto));
  }

  @GetMapping("/teachers/list")
  public ResponseEntity<List<TeacherDto>> getTeachers() {
    return ResponseEntity.ok().body(adminFacade.getAllTeachers());
  }

  @GetMapping("/student/list")
  public ResponseEntity<List<StudentDto>> getStudent() {
    return ResponseEntity.ok().body(adminFacade.getAllStudents());
  }

  @GetMapping("/classes/list")
  public ResponseEntity<List<ClassDto>> getForm() {
    return ResponseEntity.ok().body(adminFacade.getAllClasses());
  }
}