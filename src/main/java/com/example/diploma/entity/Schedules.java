package com.example.diploma.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import java.time.LocalTime;
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
public class Schedules {

  @Id
  @UuidGenerator
  @GeneratedValue(generator = "UUID")
  private UUID id;

  @OneToOne
  private Form form;

  @ManyToOne
  private Lesson lesson;

  private LocalTime startTime;

  private LocalTime endTime;

  private String room;

  @Enumerated(EnumType.STRING)
  private Day days;
}

