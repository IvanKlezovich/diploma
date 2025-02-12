package com.example.diploma.service;

import com.example.diploma.entity.Address;
import java.util.UUID;

public interface AddressService {
  Address getAddress(UUID id);
  Address saveAddress(Address address);
  void deleteAddress(UUID id);
  Address updateAddress(Address address);
}
