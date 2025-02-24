package com.example.diploma.controller;

import com.example.diploma.entity.Form;
import com.example.diploma.service.FormService;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/form")
@RequiredArgsConstructor
public class FormController {

  private final FormService formService;

  @PostMapping("/add/form")
  public Form addForm(Form form) {
    return formService.save(form);
  }

  @GetMapping("/get/all")
  public List<Form> getAllForm() {
    return formService.findAll();
  }

  @GetMapping("/get/{formId}")
  public Form getForm(@PathVariable UUID formId) {
    return formService.findById(formId);
  }

  @DeleteMapping("/delete/{id}")
  public void deleteForm(@PathVariable UUID id) {
    formService.delete(id);
  }

  @PatchMapping("/update")
  public Form updateForm(Form form) {
    return formService.update(form);
  }
}
