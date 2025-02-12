package com.example.diploma.controller;

import com.example.diploma.entity.Address;
import com.example.diploma.service.AddressService;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller("/address")
@RequiredArgsConstructor
public class AddressController {

  private final AddressService addressService;

  @GetMapping("/{id}")
  public Address getAddress(@PathVariable UUID id) {
    return addressService.getAddress(id);
  }

  @PostMapping("/add")
  public Address addAddress(@RequestBody Address address) {
    return addressService.saveAddress(address);
  }

  @DeleteMapping("/delete")
  public void deleteAddress(@RequestBody UUID id) {
    addressService.deleteAddress(id);
  }

  @PatchMapping("/update")
  public Address updateAddress(@RequestBody Address address) {
    return addressService.updateAddress(address);
  }
}
