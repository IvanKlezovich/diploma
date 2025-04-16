package com.example.diploma.fasade;

import com.example.diploma.dto.AddStudentToFormDto;
import com.example.diploma.dto.ClassDto;
import com.example.diploma.dto.CreateFormDto;
import com.example.diploma.dto.CreateLessonDto;
import com.example.diploma.dto.CreateScheduler;
import com.example.diploma.dto.CreateUserDto;
import com.example.diploma.dto.FormDto;
import com.example.diploma.dto.LessonDto;
import com.example.diploma.dto.RoleNameDto;
import com.example.diploma.dto.StudentDto;
import com.example.diploma.dto.TeacherDto;
import com.example.diploma.dto.scheduler.LessonPeriod;
import com.example.diploma.dto.scheduler.MiniFormDto;
import com.example.diploma.dto.scheduler.SchedulerWeekDto;
import com.example.diploma.dto.scheduler.SchedulesDto;
import com.example.diploma.dto.scheduler.StudyDay;
import com.example.diploma.dto.scheduler.StudyLesson;
import com.example.diploma.entity.Admin;
import com.example.diploma.entity.Day;
import com.example.diploma.entity.Form;
import com.example.diploma.entity.Lesson;
import com.example.diploma.entity.Name;
import com.example.diploma.entity.Parent;
import com.example.diploma.entity.Schedules;
import com.example.diploma.entity.Student;
import com.example.diploma.entity.Teacher;
import com.example.diploma.entity.User;
import com.example.diploma.mapper.ClassMapper;
import com.example.diploma.mapper.LessonMapper;
import com.example.diploma.mapper.StudentMapper;
import com.example.diploma.mapper.TeacherMapper;
import com.example.diploma.security.MailMessageSender;
import com.example.diploma.security.impl.PasswordGeneratorImpl;
import com.example.diploma.service.AdminService;
import com.example.diploma.service.FormService;
import com.example.diploma.service.LessonService;
import com.example.diploma.service.ParentService;
import com.example.diploma.service.SchedulerService;
import com.example.diploma.service.StudentService;
import com.example.diploma.service.TeacherService;
import com.example.diploma.service.UserService;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

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
  private final SchedulerService schedulerService;

  private final LessonMapper lessonMapper;
  private final TeacherMapper teacherMapper;
  private final ClassMapper formMapper;
  private final StudentMapper studentMapper;
  private final PasswordEncoder passwordEncoder;
  private final PasswordGeneratorImpl passwordGenerator;
  private final MailMessageSender emailService;
//  private final DataServiceImpl dataService;

  @Value("${spring.mail.username}")
  private String from;

  @Transactional
  public void addPeople(CreateUserDto createUserDto) {
    String password = "password";
    char[] passwordArray = passwordGenerator.getPassword();
    System.out.println(passwordArray);
//    emailService.send(createUserDto.email(), from, "Данные для доступа к дневнику",
//        "login: " + createUserDto.login() + "\n" + "password: " + passwordArray);
    switch (createUserDto.role()) {
      case "admin" -> createAdmin(createUserDto, password);
      case "parent" -> createParent(createUserDto, password);
      case "teacher" -> createTeacher(createUserDto, password);
      case "student" -> createStudent(createUserDto, password);
      default -> System.out.println("Такой роли нет");
    }
  }

  public void blockUser(String userId) {
    UUID blockUserId = UUID.fromString(userId);
    userService.blockUser(blockUserId);
  }

  public void addLesson(CreateLessonDto createLessonDto) {
    lessonService.addLesson(new Lesson(createLessonDto.lessonName(),
        createLessonDto.lessonDescription()));
  }

  public void changeRole(RoleNameDto roleNameDto) {
    userService.changeRoleName(roleNameDto);
  }

  public void addForm(CreateFormDto createFormDto) {
    formService.save(
        new Form(createFormDto.classname(),
            teacherService.getTeacherById(UUID.fromString(createFormDto.teacherId()))));
  }

  public List<User> getAllUsers() {
    return userService.getAllUsers();
  }

  public List<LessonDto> getAllLessons() {
    return lessonService.getAllLessons().stream()
        .map(lessonMapper::toLessonDto)
        .toList();
  }

  public List<TeacherDto> getAllTeachers() {
    return teacherService.getAllTeachers().stream()
        .map(teacherMapper::toTeacherDto)
        .toList();
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

  public void addStudentToClass(AddStudentToFormDto addStudentToFormDto) {
    Student student = studentService.getStudent(
        UUID.fromString(addStudentToFormDto.studentId()));
    student.setForm(formService.findById(
        UUID.fromString(addStudentToFormDto.classId())));
    studentMapper.toStudentDto(studentService.addStudent(student));
  }

  public List<StudentDto> getStudentByClass(UUID classId) {
    return studentMapper.toStudentDtoList(studentService.getStudentByClass(classId));
  }

  public void saveScheduler(CreateScheduler createScheduler) {
    schedulerService.saveScheduler(Schedules.builder()
        .form(formService.findById(createScheduler.classId()))
        .lesson(lessonService.getCurrentLesson(createScheduler.lessonId()))
        .room(createScheduler.apartment())
        .startTime(createScheduler.startTime())
        .endTime(createScheduler.endTime())
        .days(switch (createScheduler.dayOfWeek()) {
          case "monday" -> Day.MONDAY;
          case "tuesday" -> Day.TUESDAY;
          case "wednesday" -> Day.WEDNESDAY;
          case "thursday" -> Day.THURSDAY;
          case "friday" -> Day.FRIDAY;
          case "saturday" -> Day.SATURDAY;
          default ->
              throw new IllegalStateException("Unexpected value: " + createScheduler.dayOfWeek());
        })
        .build());
  }

  public SchedulerWeekDto getAllScheduler() {
    List<Schedules> schedules = schedulerService.getAllSchedulers();
    List<Form> forms = formService.findAll();
    List<MiniFormDto> firstFragment = forms.stream()
        .map(entity -> MiniFormDto.builder()
            .name(entity.getName())
            .formId(entity.getId())
            .build())
        .toList();

    SchedulerWeekDto schedulerWeekDto = mapToSchedulerWeekDto(schedules);
    schedulerWeekDto.setFormList(firstFragment);

    return schedulerWeekDto;
  }

  private SchedulerWeekDto mapToSchedulerWeekDto(List<Schedules> schedules) {

    return SchedulerWeekDto.builder()
        .form(schedules.stream()
            .map(schedule -> SchedulesDto.builder()
                .form(mapFormToDto(schedule.getForm()))
                .studyDays(mapToStudyDay(schedules, schedule.getForm()))
                .build())
            .toList())
        .build();
  }

  private MiniFormDto mapFormToDto(Form form) {
    return new MiniFormDto(form.getId(), form.getName());
  }

  private List<StudyDay> mapToStudyDay(List<Schedules> schedules, Form form) {
    return schedules.stream()
        .filter(e -> e.getForm().getName().equals(form.getName()))
        .map(schedule -> StudyDay.builder()
            .dayOfWeek(schedule.getDays())
            .lesson(mapStudyLessonToDto(schedules, form, schedule.getDays()))
            .build())
        .toList();
  }

  private List<StudyLesson> mapStudyLessonToDto(List<Schedules> schedules, Form form,
      Day dayOfWeek) {
    return schedules.stream()
        .filter(e -> e.getForm().getName().equals(form.getName()) && e.getDays().equals(dayOfWeek))
        .map(schedule -> StudyLesson.builder()
            .lesson(schedule.getLesson())
            .time(new LessonPeriod(schedule.getStartTime(), schedule.getEndTime()))
            .build())
        .toList();
  }

  public void saveSchedulerByFile(MultipartFile file, String className, String fileType) {
//    dataService.uploadData(file);
  }

  private void createStudent(CreateUserDto createUserDto, String password) {
    studentService.addStudent(new Student(new Name(createUserDto.firstname(),
        createUserDto.surname(), createUserDto.lastname()), createUserDto.email(),
        createUserDto.phone(), createUserDto.login(), passwordEncoder.encode(password),
        createUserDto.timeLimit()));
  }

  private void createTeacher(CreateUserDto createUserDto, String password) {
    teacherService.addTeacher(new Teacher(new Name(createUserDto.firstname(),
        createUserDto.surname(), createUserDto.lastname()), createUserDto.email(),
        createUserDto.phone(), createUserDto.login(), passwordEncoder.encode(password),
        createUserDto.timeLimit()));
  }

  private void createParent(CreateUserDto createUserDto, String password) {
    parentService.addParent(new Parent(new Name(createUserDto.firstname(),
        createUserDto.surname(), createUserDto.lastname()), createUserDto.email(),
        createUserDto.phone(), createUserDto.login(), passwordEncoder.encode(password),
        createUserDto.job(), createUserDto.description(), List.of(new Student()),
        createUserDto.timeLimit()));
  }

  private void createAdmin(CreateUserDto createUserDto, String password) {
    adminService.addAdmin(new Admin(new Name(createUserDto.firstname(),
        createUserDto.surname(), createUserDto.lastname()), createUserDto.email(),
        createUserDto.phone(), createUserDto.login(), passwordEncoder.encode(password),
        createUserDto.timeLimit()));
  }
}
