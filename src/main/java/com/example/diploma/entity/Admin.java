package com.example.diploma.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import java.io.Serializable;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@DiscriminatorValue("ADMIN")
public class Admin extends User implements Serializable {

  public Admin(Name name, String email, String phone, String login, String password, Role role) {
    super(name, email, phone, login, password, role);
  }
}
