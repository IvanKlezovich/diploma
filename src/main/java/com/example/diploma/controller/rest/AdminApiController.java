package com.example.diploma.controller.rest;

import com.example.diploma.dto.CreateUserDto;
import com.example.diploma.entity.User;
import com.example.diploma.fasade.AdminFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminApiController {

  private final AdminFacade adminFacade;

  @PostMapping("/users/add")
  public ResponseEntity<User> addUser(CreateUserDto createUserDto) {
    User users = adminFacade.addPeople(createUserDto);
    return ResponseEntity.ok().body(users);
  }

  @PatchMapping("/users/block")
  public ResponseEntity<User> blockUser(String userData) {
    System.out.println(userData);
    return ResponseEntity.ok().body(new User());
  }

  @DeleteMapping("users/delete/role")
  public ResponseEntity<User> deleteUser(String userData) {
    return null;
  }

  @PatchMapping("users/edit")
  public ResponseEntity<User> editUser(String userData) {
    return null;
  }
}