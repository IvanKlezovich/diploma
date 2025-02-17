package com.example.diploma.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
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
@Table(name = "address")
public class Address implements Serializable {

  @Id
  @UuidGenerator
  @GeneratedValue(generator = "UUID")
  @Column(name = "id")
  private UUID id;

  @Column(name = "apartment")
  private Long  apartment;

  @Column(name = "house_number")
  private String houseNumber;

  @Column(name = "street")
  private String street;

  @Column(name = "city")
  private String city;

  @Column(name = "state")
  private String state;

  @Column(name = "zip")
  private String zip;

  @Column(name = "country")
  private String country;

  @Column(name = "phone")
  private String phone;
}
