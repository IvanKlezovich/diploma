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
@Table(name = "class")
public class Class implements Serializable {

  @Id
  @GeneratedValue(generator = "UUID")
  @UuidGenerator
  @Column(name = "class_id")
  private UUID classId;

  @Column(name = "class_name")
  private String className;

  @OneToOne(mappedBy = "teacher_id")
  @Column(name = "teacher")
  private Teacher classTeacher;
}
