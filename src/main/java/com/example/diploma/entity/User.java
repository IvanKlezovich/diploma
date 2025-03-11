package com.example.diploma.entity;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "role")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {

  @Id
  @UuidGenerator
  @GeneratedValue(generator = "UUID")
  private UUID id;

  @Embedded
  private Name name;

  private String email;

  private String phone;

  private String login;

  private String password;

  @Enumerated(EnumType.STRING)
  @Column(insertable = false, updatable = false)
  private Role role;

  private Boolean isBlocked;

  public User(Name name, String email, String phone, String login, String password, Role role) {
    this.name = name;
    this.email = email;
    this.phone = phone;
    this.login = login;
    this.password = password;
    this.role = role;
    isBlocked = false;
  }
}
