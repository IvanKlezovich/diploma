package com.example.diploma.service;

import com.example.diploma.dto.RoleNameDto;
import com.example.diploma.entity.User;
import java.util.List;
import java.util.UUID;

public interface UserService {

  List<User> getAllUsers();

  void blockUser(UUID blockUserId);

  void changeRoleName(RoleNameDto roleNameDto);
}
