package com.example.diploma.service.impl;

import com.example.diploma.entity.Form;
import com.example.diploma.repository.FormRepository;
import com.example.diploma.service.FormService;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class FormServiceImpl implements FormService {

  private final FormRepository formRepository;

  public Form save(Form form) {
    return formRepository.save(form);
  }

  @Transactional(readOnly = true)
  public List<Form> findAll() {
    return formRepository.findAll();
  }

  @Transactional(readOnly = true)
  public Form findById(UUID id) {
    return formRepository.findById(id)
        .orElse(null);
  }

  public void delete(UUID id) {
    formRepository.deleteById(id);
  }

  public Form update(Form form) {
    return formRepository.save(form);
  }
}
