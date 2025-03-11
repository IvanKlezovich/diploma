package com.example.diploma.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@DiscriminatorValue("STUDENT")
public class Student extends User implements Serializable {

  @ManyToOne
  private Form form;

  public Student(Name name, String email, String phone, String login, String password, Role role) {
    super(name, email, phone, login, password, role);
  }

}
