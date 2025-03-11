package com.example.diploma.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import java.io.Serializable;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@DiscriminatorValue("TEACHER")
public class Teacher extends User implements Serializable {

  private short seniority;

  @OneToOne
  private Form form;

  @OneToMany
  private Set<Lesson> lessons;

  public Teacher(Name name, String email, String phone, String login, String password, Role role) {
    super(name, email, phone, login, password, role);
  }
}
