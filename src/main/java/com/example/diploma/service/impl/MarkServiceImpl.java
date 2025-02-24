package com.example.diploma.service.impl;

import com.example.diploma.entity.Mark;
import com.example.diploma.repository.MarkRepository;
import com.example.diploma.service.MarkService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MarkServiceImpl implements MarkService {

  private final MarkRepository markRepository;


  @Override
  public void addMark(Mark mark) {
    markRepository.save(mark);
  }

  @Override
  public void editMark(Mark mark) {
    markRepository.save(mark);
  }
}
