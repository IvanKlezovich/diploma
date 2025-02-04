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
import java.util.Set;
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
@Table(name = "teacher")
public class Teacher implements Serializable {

  @Id
  @UuidGenerator
  @GeneratedValue(generator = "UUID")
  @Column(name = "id")
  private UUID id;

  @Embedded
  @Column(name = "name")
  private Name name;

  @Column(name = "age")
  private short age;

  @Column(name = "seniority")
  private short seniority;

  @OneToOne
  private Class classTeacher;

  @OneToMany
  @Column(name = "specialization_id")
  private Set<Lesson> lessons;

  @OneToOne
  private Address address;
}
