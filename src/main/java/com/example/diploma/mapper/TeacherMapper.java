package com.example.diploma.mapper;

import com.example.diploma.dto.TeacherDto;
import com.example.diploma.entity.Teacher;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TeacherMapper {

  @Mapping(source = "teacher.name.firstname", target = "firstname")
  @Mapping(source = "teacher.name.lastname", target = "lastname")
  @Mapping(source = "teacher.name.surname", target = "surname")
  @Mapping(source = "teacher.id", target = "id")
  TeacherDto toTeacherDto(Teacher teacher);
}
