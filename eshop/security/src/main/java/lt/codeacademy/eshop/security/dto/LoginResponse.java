package lt.codeacademy.eshop.security.dto;

import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

@Getter
public class LoginResponse {
  private final String username;
  private final Set<String> roles;
  private final String fullname;
  private final String token;

  public LoginResponse(UserPrincipalDto principalDto, String token) {
    username = principalDto.getUsername();
    roles = principalDto.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toSet());
    fullname = principalDto.getFullName();
    this.token = token;
  }
}
