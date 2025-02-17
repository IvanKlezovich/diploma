package com.example.diploma.controller;

import com.example.diploma.dto.AddressDto;
import com.example.diploma.service.AddressService;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/address")
@RequiredArgsConstructor
public class AddressController {

  private final AddressService addressService;

  @GetMapping("/all")
  public List<AddressDto> getAll() {
    return addressService.getAllAddresses();
  }

  @GetMapping("/{id}")
  public AddressDto getAddress(@PathVariable UUID id) {
    return addressService.getAddress(id);
  }

  @PostMapping("/add")
  public AddressDto addAddress(@RequestBody AddressDto address) {
    return addressService.saveAddress(address);
  }

  @DeleteMapping("/delete")
  public void deleteAddress(@RequestBody UUID id) {
    addressService.deleteAddress(id);
  }

  @PatchMapping("/update")
  public AddressDto updateAddress(@RequestBody AddressDto address) {
    return addressService.updateAddress(address);
  }
}
