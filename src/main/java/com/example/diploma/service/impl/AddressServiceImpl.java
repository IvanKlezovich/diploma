package com.example.diploma.service.impl;

import com.example.diploma.entity.Address;
import com.example.diploma.repository.AddressRepository;
import com.example.diploma.service.AddressService;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {

  private final AddressRepository addressRepository;

  @Override
  public Address getAddress(UUID id) {
    return addressRepository.getById(id);
  }

  @Override
  public Address saveAddress(Address address) {
    return addressRepository.save(address);
  }

  @Override
  public void deleteAddress(UUID id) {
    addressRepository.deleteById(id);
  }

  @Override
  public Address updateAddress(Address address) {
    return addressRepository.save(address);
  }
}
