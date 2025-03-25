package com.example.diploma.controller.rest;

import com.example.diploma.dto.AddStudentToFormDto;
import com.example.diploma.dto.BlockUserDto;
import com.example.diploma.dto.ClassDto;
import com.example.diploma.dto.CreateFormDto;
import com.example.diploma.dto.CreateLessonDto;
import com.example.diploma.dto.CreateScheduler;
import com.example.diploma.dto.CreateUserDto;
import com.example.diploma.dto.LessonDto;
import com.example.diploma.dto.RoleNameDto;
import com.example.diploma.dto.StudentDto;
import com.example.diploma.dto.TeacherDto;
import com.example.diploma.entity.User;
import com.example.diploma.fasade.AdminFacade;
import com.example.diploma.service.SchedulerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminApiController {

  private final AdminFacade adminFacade;
  private final SchedulerService schedulerService;

  @PostMapping("/users/add")
  public ResponseEntity<Void> addUser(CreateUserDto createUserDto) {
    adminFacade.addPeople(createUserDto);
    return ResponseEntity.ok().build();
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
  public ResponseEntity<Void> addLesson(CreateLessonDto createLessonDto) {
    adminFacade.addLesson(createLessonDto);
    return ResponseEntity.ok().build();
  }

  @PostMapping("/class/add")
  public ResponseEntity<Void> getForm(@RequestBody CreateFormDto createFormDto) {
    adminFacade.addForm(createFormDto);
    return ResponseEntity.ok().build();
  }

  @PostMapping("/scheduler/add")
  public ResponseEntity<Void> addScheduler(@RequestBody CreateScheduler createScheduler) {
    adminFacade.saveScheduler(createScheduler);
    return ResponseEntity.ok().body(null);
  }

  @PostMapping("/classes/add-student")
  public ResponseEntity<Void> getStudent(
      @RequestBody AddStudentToFormDto addStudentToFormDto) {
    adminFacade.addStudentToClass(addStudentToFormDto);
    return ResponseEntity.ok().build();
  }

  @GetMapping("class/{classId}/list")
  public ResponseEntity<List<StudentDto>> getAllStudents(@PathVariable String classId) {
    return ResponseEntity.ok().body(adminFacade.getStudentByClass(UUID.fromString(classId)));
  }

  @GetMapping("/lesson/list")
  public ResponseEntity<List<LessonDto>> getLessonList() {
    return ResponseEntity.ok().body(adminFacade.getAllLessons());
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
