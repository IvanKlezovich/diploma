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
import java.time.LocalDate;
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

  @Column(insertable = false, updatable = false)
  private LocalDate created;

  private LocalDate timeLimit;

  private Boolean isBlocked;

  public User(Name name, String email,
      String phone, String login, String password,
      LocalDate timeLimit) {
    this.name = name;
    this.email = email;
    this.phone = phone;
    this.login = login;
    this.password = password;
    this.timeLimit = timeLimit;
    isBlocked = false;
    created = LocalDate.now();
  }
}
