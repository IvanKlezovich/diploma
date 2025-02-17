package com.example.diploma.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AddressDto {

  private Long apartment;

  private String houseNumber;

  private String street;

  private String city;

  private String state;

  private String zip;

  private String country;

  private String phone;
}
