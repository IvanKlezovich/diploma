package com.example.diploma.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "student")
public class Student implements Serializable {

  @Id
  @UuidGenerator
  @GeneratedValue(generator = "UUID")
  @Column(name = "student_id")
  private UUID id;

  @Embedded
  @Column(name = "name")
  private Name name;

  @OneToOne
  private Address address;

  @Column(name = "student")
  private String phone;

  @OneToMany
  @Column(name = "homeworks")
  private List<Homework> homeworks;

  @OneToMany
  @Column(name = "parent")
  private Set<Parent> parent;

  @ManyToOne
  private Class learningClass;

  @OneToMany
  @Column(name = "comment")
  private List<Comment> comment;
}
