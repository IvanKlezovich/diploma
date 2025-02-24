package com.example.diploma.service.impl;

import com.example.diploma.entity.Homework;
import com.example.diploma.repository.HomeworkRepository;
import com.example.diploma.service.HomeworkService;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HomeworkServiceImpl implements HomeworkService {

  private final HomeworkRepository homeworkRepository;

  @Override
  public Homework addHomework(Homework homework) {
    return homeworkRepository.save(homework);
  }

  @Override
  public Homework editHomework(Homework homework) {
    return homeworkRepository.save(homework);
  }

  @Override
  public Homework getHomework(UUID homeworkId) {
    return homeworkRepository.findById(homeworkId)
        .orElse(null);
  }
}
