package lt.codeacademy.eshop.security.controller;

import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lt.codeacademy.eshop.security.dto.LoginRequest;
import lt.codeacademy.eshop.security.dto.LoginResponse;
import lt.codeacademy.eshop.security.dto.UserPrincipalDto;
import lt.codeacademy.eshop.security.provider.JwtProvider;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class LoginController {

  private final JwtProvider jwtProvider;
  private final AuthenticationManager authenticationManager;

  @PostMapping("/login")
  public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest, HttpServletResponse response) {
    return Optional.of(authenticate(loginRequest))
      .map(auth -> (UserPrincipalDto) auth.getPrincipal())
      .map(principalDto -> ResponseEntity.ok(
        new LoginResponse(principalDto, jwtProvider.getToken(principalDto), jwtProvider.getTokenExpiresInSeconds()))
      )
      .orElseThrow(() -> new BadCredentialsException("Authentication failed!"));
  }

  private Authentication authenticate(LoginRequest loginRequest) {
    return authenticationManager.authenticate(
      UsernamePasswordAuthenticationToken.unauthenticated(loginRequest.username(), loginRequest.password()));
  }
}
