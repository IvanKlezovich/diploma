package com.example.diploma.fasade;

import com.example.diploma.dto.CreateUserDto;
import com.example.diploma.entity.Admin;
import com.example.diploma.entity.Name;
import com.example.diploma.entity.Parent;
import com.example.diploma.entity.Role;
import com.example.diploma.entity.Student;
import com.example.diploma.entity.Teacher;
import com.example.diploma.entity.User;
import com.example.diploma.service.AdminService;
import com.example.diploma.service.ParentService;
import com.example.diploma.service.StudentService;
import com.example.diploma.service.TeacherService;
import com.example.diploma.service.UserService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AdminFacade {

  private final UserService userService;
  private final StudentService studentService;
  private final TeacherService teacherService;
  private final ParentService parentService;
  private final AdminService adminService;

  public User addPeople(CreateUserDto createUserDto) {
    return switch (createUserDto.role()) {
      case "admin" -> adminService.addAdmin(new Admin(new Name(createUserDto.firstname(),
          createUserDto.surname(), createUserDto.lastname()), createUserDto.email(),
          createUserDto.phone(), createUserDto.login(), "password", Role.ADMIN));
      case "parent" -> parentService.addParent(new Parent(new Name(createUserDto.firstname(),
          createUserDto.surname(), createUserDto.lastname()), createUserDto.email(),
          createUserDto.phone(), createUserDto.login(), "password", Role.PARENT,
          createUserDto.job(), createUserDto.description(), List.of(new Student())));
      case "teacher" -> teacherService.addTeacher(new Teacher(new Name(createUserDto.firstname(),
          createUserDto.surname(), createUserDto.lastname()), createUserDto.email(),
          createUserDto.phone(), createUserDto.login(), "password", Role.TEACHER));
      case "student" -> studentService.addStudent(new Student(new Name(createUserDto.firstname(),
          createUserDto.surname(), createUserDto.lastname()), createUserDto.email(),
          createUserDto.phone(), createUserDto.login(), "password", Role.STUDENT));
      default -> null;
    };
  }

  public List<User> getAllUsers() {
    return userService.getAllUsers();
  }
}
