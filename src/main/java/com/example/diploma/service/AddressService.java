package com.example.diploma.service;

import com.example.diploma.dto.AddressDto;
import com.example.diploma.entity.Address;

import java.util.List;
import java.util.UUID;

public interface AddressService {
  AddressDto getAddress(UUID id);
  AddressDto saveAddress(AddressDto addressDto);
  void deleteAddress(UUID id);
  AddressDto updateAddress(AddressDto addressDto);
  List<AddressDto> getAllAddresses();
}
