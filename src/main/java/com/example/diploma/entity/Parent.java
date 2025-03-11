package com.example.diploma.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import java.io.Serializable;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@DiscriminatorValue("PARENT")
public class Parent extends User implements Serializable {

  private String job;

  private String description;

  @OneToMany
  private List<Student> students;

  public Parent(Name name, String email, String phone, String login, String password, Role role,
      String job, String description, List<Student> students) {
    super(name, email, phone, login, password, role);
    this.job = job;
    this.description = description;
    this.students = students;
  }
}
