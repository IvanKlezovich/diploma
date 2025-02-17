package com.example.diploma.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import java.io.Serializable;
import java.time.LocalDateTime;
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
public class Messages implements Serializable {

  LocalDateTime addData;
  @Id
  @UuidGenerator
  @GeneratedValue(generator = "UUID")
  private UUID id;
  private String description;

  private UUID fromUser;

  private UUID toUser;

  @Column(name = "read", columnDefinition = "bool default false")
  private boolean read = false;
}
