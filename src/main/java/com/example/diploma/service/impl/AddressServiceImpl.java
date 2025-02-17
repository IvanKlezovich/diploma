package com.example.diploma.service.impl;

import com.example.diploma.dto.AddressDto;
import com.example.diploma.entity.Address;
import com.example.diploma.mapper.AddressMapper;
import com.example.diploma.repository.AddressRepository;
import com.example.diploma.service.AddressService;

import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {

  private final AddressRepository addressRepository;
  private final AddressMapper addressMapper;

  @Override
  public AddressDto getAddress(UUID id) {
    return addressMapper.toAddressDto(addressRepository.findById(id)
            .orElse(null));
  }

  @Override
  public AddressDto saveAddress(AddressDto addressDto) {
    return addressMapper.toAddressDto(
            addressRepository.save(
                    addressMapper.toEntity(addressDto)));
  }

  @Override
  public void deleteAddress(UUID id) {
    addressRepository.deleteById(id);
  }

  @Override
  public AddressDto updateAddress(AddressDto addressDto) {
    return addressMapper.toAddressDto(
            addressRepository.save(
                    addressMapper.toEntity(addressDto)));
  }

  public List<AddressDto> getAllAddresses() {
    return addressMapper.toAddressDtoList(addressRepository.findAll());
  }
}
