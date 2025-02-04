package com.example.diploma.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.List;
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
@Table(name = "parent")
public class Parent implements Serializable {

  @Id
  @UuidGenerator
  @GeneratedValue(generator = "UUID")
  @Column(name = "id")
  private UUID id;

  @Embedded
  @Column(name = "parent_name")
  private Name name;

  @Column(name = "job")
  private String job;

  @OneToOne
  private Address address;

  @Column(name = "description")
  private String description;

  @OneToMany
  @Column(name = "student")
  private List<Student> students;
}
