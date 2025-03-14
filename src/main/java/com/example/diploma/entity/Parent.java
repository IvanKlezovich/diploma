package com.example.diploma.entity;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import java.io.Serializable;
import java.time.LocalDate;
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

  @Column(insertable = false, updatable = false)
  private Role role = Role.PARENT;

  public Parent(Name name, String email, String phone, String login, String password,
      String job, String description, List<Student> students, LocalDate timeLimit) {
    super(name, email, phone, login, password, timeLimit);
    this.job = job;
    this.description = description;
    this.students = students;
  }
}
