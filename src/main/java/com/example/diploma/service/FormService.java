package com.example.diploma.service;

import com.example.diploma.entity.Form;
import java.util.List;
import java.util.UUID;

public interface FormService {

  Form save(Form form);

  List<Form> findAll();

  Form findById(UUID id);

  void delete(UUID id);

  Form update(Form form);
}
