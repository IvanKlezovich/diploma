package com.example.diploma.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import java.io.Serializable;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Form implements Serializable {

  @Id
  @GeneratedValue(generator = "UUID")
  @UuidGenerator
  private UUID Id;

  private String name;

  @OneToOne
  private Teacher classTeacher;

  public Form(String name, Teacher classTeacher) {
    this.name = name;
    this.classTeacher = classTeacher;
  }
}
