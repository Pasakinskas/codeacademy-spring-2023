package lt.codeacademy.eshop.security.controller;

import jakarta.servlet.http.HttpServletResponse;
import lt.codeacademy.eshop.security.dto.LoginResponse;
import lt.codeacademy.eshop.security.dto.UserPrincipalDto;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

  @PostMapping("/login")
  public LoginResponse login(@AuthenticationPrincipal UserPrincipalDto principalDto, HttpServletResponse response) {
    return new LoginResponse(principalDto, response.getHeader(HttpHeaders.AUTHORIZATION));
  }
}
