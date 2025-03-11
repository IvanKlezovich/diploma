package com.example.diploma.service.impl;

import com.example.diploma.entity.Admin;
import com.example.diploma.repository.AdminRepository;
import com.example.diploma.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {

  private final AdminRepository adminRepository;

  public Admin addAdmin(Admin admin) {
    return adminRepository.save(admin);
  }
}
