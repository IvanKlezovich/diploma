package com.example.diploma.config.security;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

  @Override
  public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
      Authentication authentication) throws ServletException {

    Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();

    authorities.stream()
        .map(GrantedAuthority::getAuthority)
        .forEach(authority -> {
          String targetUrl = getTargetUrl(authority);
          try {
            response.sendRedirect(targetUrl);
          } catch (IOException e) {
            throw new RuntimeException(e);
          }
        });
  }

  private String getTargetUrl(String authority) {
    return switch (authority) {
      case "ROLE_ADMIN" -> "/dairy-project/admin/";
      case "ROLE_TEACHER" -> "/dairy-project/teacher/";
      case "ROLE_STUDENT" -> "/dairy-project/student/";
      default -> "/";
    };
  }
}
