package com.example.diploma.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "mark")
public class Mark {

  @Id
  @GeneratedValue(generator = "Short")
  @Column(name = "id")
  private short id;

  @Column(name = "mark")
  private short mark;

  @Column(name = "description")
  private String markDescription;
}
