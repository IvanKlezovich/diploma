package com.example.diploma.entity;

import jakarta.persistence.Embedded;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public class Users {

  @Embedded
  private Name name;
  private String email;
  private String phone;
  @OneToOne
  private Address addressDto;


  private String login;
  private String password;
}
