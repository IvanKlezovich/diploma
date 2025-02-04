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
@Table(name = "homework")
public class Homework implements Serializable {

  @Id
  @UuidGenerator
  @GeneratedValue(generator = "UUID")
  @Column(name = "homework_id")
  private UUID homeworkId;

  @Column(name = "task")
  private String task;

  @OneToOne
  private Mark mark;

  @Column(name = "done")
  private boolean isDone;

  @Column(name = "homework_url")
  private String url;
}
