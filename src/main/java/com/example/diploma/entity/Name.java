package com.example.diploma.entity;

import jakarta.persistence.Column;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Name implements Serializable {

  @Column(name = "firstname")
  private String firstname;

  @Column(name = "surname")
  private String surname;

  @Column(name = "lastname")
  private String lastname;

  @Column(name = "full_name")
  private String fullName;

  public Name(String firstname, String surname, String lastname) {
    this.firstname = firstname;
    this.surname = surname;
    this.lastname = lastname;
  }
}
