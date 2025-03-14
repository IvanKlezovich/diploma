package com.example.diploma.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Mark {

  @Id
  @GeneratedValue(generator = "Short")
  private Long id;
  private short mark;
  @OneToOne
  private Student student;
  @OneToOne
  private Lesson lesson;
  private LocalDateTime mark_date;

  public Mark(short mark, Student student, Lesson lesson, LocalDateTime mark_date) {
    this.mark = mark;
    this.student = student;
    this.lesson = lesson;
    this.mark_date = mark_date;
  }
}
