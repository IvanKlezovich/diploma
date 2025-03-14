package com.example.diploma.mapper;

import com.example.diploma.dto.StudentDto;
import com.example.diploma.entity.Student;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface StudentMapper {

  @Mapping(source = "student.id", target = "studentId")
  @Mapping(source = "student.name.firstname", target = "name")
  @Mapping(source = "student.name.lastname", target = "secondName")
  StudentDto toStudentDto(Student student);
}
