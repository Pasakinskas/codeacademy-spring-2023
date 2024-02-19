package lt.codeacademy.eshop.security.provider;

import lt.codeacademy.eshop.security.dto.UserPrincipalDto;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

@Component
public class JwtProvider {

  public String getToken(Authentication authentication) {
    final UserPrincipalDto principalDto = (UserPrincipalDto) authentication.getPrincipal();

    return "cia mano tokenas";
  }
}
