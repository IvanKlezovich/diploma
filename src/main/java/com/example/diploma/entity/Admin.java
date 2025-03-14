package com.example.diploma.entity;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import java.io.Serializable;
import java.time.LocalDate;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@DiscriminatorValue("ADMIN")
public class Admin extends User implements Serializable {

  @Column(insertable = false, updatable = false)
  private Role role = Role.ADMIN;

  public Admin(Name name, String email,
      String phone, String login, String password,
      LocalDate timeLimit) {
    super(name, email, phone, login, password, timeLimit);
  }
}
