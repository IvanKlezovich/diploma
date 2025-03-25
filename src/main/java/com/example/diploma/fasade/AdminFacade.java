package com.example.diploma.fasade;

import com.example.diploma.dto.AddStudentToFormDto;
import com.example.diploma.dto.ClassDto;
import com.example.diploma.dto.CreateFormDto;
import com.example.diploma.dto.CreateLessonDto;
import com.example.diploma.dto.CreateUserDto;
import com.example.diploma.dto.FormDto;
import com.example.diploma.dto.LessonDto;
import com.example.diploma.dto.RoleNameDto;
import com.example.diploma.dto.StudentDto;
import com.example.diploma.dto.TeacherDto;
import com.example.diploma.entity.Admin;
import com.example.diploma.entity.Form;
import com.example.diploma.entity.Lesson;
import com.example.diploma.entity.Name;
import com.example.diploma.entity.Parent;
import com.example.diploma.entity.Student;
import com.example.diploma.entity.Teacher;
import com.example.diploma.entity.User;
import com.example.diploma.mapper.ClassMapper;
import com.example.diploma.mapper.LessonMapper;
import com.example.diploma.mapper.StudentMapper;
import com.example.diploma.mapper.TeacherMapper;
import com.example.diploma.service.AdminService;
import com.example.diploma.service.FormService;
import com.example.diploma.service.LessonService;
import com.example.diploma.service.ParentService;
import com.example.diploma.service.StudentService;
import com.example.diploma.service.TeacherService;
import com.example.diploma.service.UserService;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
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
  private final LessonService lessonService;
  private final FormService formService;

  private final LessonMapper lessonMapper;
  private final TeacherMapper teacherMapper;
  private final ClassMapper formMapper;
  private final StudentMapper studentMapper;

  public User addPeople(CreateUserDto createUserDto) {
    return switch (createUserDto.role()) {
      case "admin" -> adminService.addAdmin(new Admin(new Name(createUserDto.firstname(),
          createUserDto.surname(), createUserDto.lastname()), createUserDto.email(),
          createUserDto.phone(), createUserDto.login(), "password", createUserDto.timeLimit()));
      case "parent" -> parentService.addParent(new Parent(new Name(createUserDto.firstname(),
          createUserDto.surname(), createUserDto.lastname()), createUserDto.email(),
          createUserDto.phone(), createUserDto.login(), "password",
          createUserDto.job(), createUserDto.description(), List.of(new Student()),
          createUserDto.timeLimit()));
      case "teacher" -> teacherService.addTeacher(new Teacher(new Name(createUserDto.firstname(),
          createUserDto.surname(), createUserDto.lastname()), createUserDto.email(),
          createUserDto.phone(), createUserDto.login(), "password",
          createUserDto.timeLimit()));
      case "student" -> studentService.addStudent(new Student(new Name(createUserDto.firstname(),
          createUserDto.surname(), createUserDto.lastname()), createUserDto.email(),
          createUserDto.phone(), createUserDto.login(), "password",
          createUserDto.timeLimit()));
      default -> null;
    };
  }

  public List<User> getAllUsers() {
    return userService.getAllUsers();
  }

  public void blockUser(String userId) {
    UUID blockUserId = UUID.fromString(userId);
    userService.blockUser(blockUserId);
  }

  public Lesson addLesson(CreateLessonDto createLessonDto) {
    return lessonService.addLesson(new Lesson(createLessonDto.lessonName(),
            createLessonDto.lessonDescription()));
  }

  public List<LessonDto> getAllLessons() {
    return lessonService.getAllLessons().stream()
        .map(lessonMapper::toLessonDto)
        .collect(Collectors.toList());
  }

  public void changeRole(RoleNameDto roleNameDto) {
    userService.changeRoleName(roleNameDto);
  }

  public List<TeacherDto> getAllTeachers() {
    return teacherService.getAllTeachers().stream()
        .map(teacherMapper::toTeacherDto)
        .toList();
  }

  public Form addForm(CreateFormDto createFormDto) {
    return formService.save(
        new Form(createFormDto.classname(),
            teacherService.getTeacherById(UUID.fromString(createFormDto.teacherId()))));
  }

  public List<FormDto> getAllForms() {
    return formService.findAll().stream()
        .map(formMapper::toFormDto)
        .toList();
  }

  public List<StudentDto> getAllStudents() {
    return studentService.findAll().stream()
        .map(studentMapper::toStudentDto)
        .toList();
  }

  public List<ClassDto> getAllClasses() {
    return formService.findAll().stream()
        .map(formMapper::toClassDto)
        .toList();
  }

  public StudentDto addStudentToClass(AddStudentToFormDto addStudentToFormDto) {
    Student student = studentService.getStudent(
        UUID.fromString(addStudentToFormDto.studentId()));
    student.setForm(formService.findById(
        UUID.fromString(addStudentToFormDto.classId())));
    return studentMapper.toStudentDto(studentService.addStudent(student));
  }

  public List<StudentDto> getStudentByClass(UUID classId) {
    return studentMapper.toStudentDtoList(studentService.getStudentByClass(classId));
  }
}
