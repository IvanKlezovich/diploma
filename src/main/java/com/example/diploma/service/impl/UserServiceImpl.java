package com.example.diploma.service.impl;

import com.example.diploma.dto.RoleNameDto;
import com.example.diploma.entity.User;
import com.example.diploma.repository.UserRepository;
import com.example.diploma.service.UserService;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;

  @Override
  @Transactional(readOnly = true)
  public List<User> getAllUsers() {
    return userRepository.findAll();
  }

  @Override
  @Transactional
  public Boolean blockUser(UUID blockUserId) {
    try {
      userRepository.blockUser(blockUserId);
      return true;
    } catch (Exception e) {
      return false;
    }
  }

  @Override
  @Transactional
  public void changeRoleName(RoleNameDto roleNameDto) {
    userRepository.changeRole(roleNameDto.userId(), switch (roleNameDto.roleName()) {
      case "admin" -> "ADMIN";
      case "teacher" -> "TEACHER";
      case "student" -> "STUDENT";
      case "parent" -> "PARENT";
      default -> throw new IllegalStateException("Unexpected value: " + roleNameDto);
    });
  }
}
