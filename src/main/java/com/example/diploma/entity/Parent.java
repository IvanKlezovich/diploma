package com.example.diploma.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Parent extends Users implements Serializable {

  @Id
  @UuidGenerator
  @GeneratedValue(generator = "UUID")
  private UUID id;

  private String job;

  private String description;

  @OneToMany
  private List<Student> students;
}
