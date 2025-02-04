package com.example.diploma.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.io.Serializable;
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
@Table(name = "lessons")
public class Lesson implements Serializable {

  @Id
  @UuidGenerator
  @GeneratedValue(generator = "UUID")
  @Column(name = "id")
  private UUID id;

  @Column(name = "title")
  private String title;

  @OneToOne
  private Homework homework;

  @OneToOne
  private Mark mark;
}
