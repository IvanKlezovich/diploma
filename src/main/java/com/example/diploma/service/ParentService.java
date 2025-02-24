package com.example.diploma.service;

import com.example.diploma.entity.Parent;
import com.example.diploma.entity.Student;
import java.util.List;
import java.util.UUID;

public interface ParentService {

  List<Parent> getParent(UUID studentId);

  void deleteParent(UUID parentId);

  Parent addChildren(Student student);
}
