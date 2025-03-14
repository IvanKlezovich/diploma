package com.example.diploma.mapper;

import com.example.diploma.dto.ClassDto;
import com.example.diploma.dto.FormDto;
import com.example.diploma.entity.Form;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ClassMapper {

  @Mapping(source = "form.classTeacher.name.firstname", target = "teacher.firstname")
  @Mapping(source = "form.classTeacher.name.lastname", target = "teacher.lastname")
  @Mapping(source = "form.classTeacher.name.surname", target = "teacher.surname")
  @Mapping(source = "form.classTeacher.id", target = "teacher.id")
  @Mapping(source = "form.id", target = "id")
  @Mapping(source = "form.name", target = "classname")
  FormDto toFormDto(Form form);

  @Mapping(source = "form.id", target = "classId")
  @Mapping(source = "form.name", target = "classname")
  @Mapping(source = "form.classTeacher.name.fullName", target = "teacherName")
  ClassDto toClassDto(Form form);
}
