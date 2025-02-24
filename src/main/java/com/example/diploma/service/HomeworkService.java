package com.example.diploma.service;

import com.example.diploma.entity.Homework;
import java.util.UUID;

public interface HomeworkService {

  Homework addHomework(Homework homework);

  Homework editHomework(Homework homework);

  Homework getHomework(UUID homeworkId);
}
