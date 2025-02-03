package com.example.diploma.entity;

import jakarta.persistence.Column;

public class Name {

  @Column(name = "firstname")
  private String firstname;

  @Column(name = "surname")
  private String surname;

  @Column(name = "lastname")
  private String lastname;

  @Column(name = "full_name")
  private String fullName;

}
