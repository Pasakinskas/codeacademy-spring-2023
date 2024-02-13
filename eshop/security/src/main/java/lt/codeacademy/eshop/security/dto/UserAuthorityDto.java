package lt.codeacademy.eshop.security.dto;

import lombok.Builder;
import lt.codeacademy.eshop.security.domain.AuthorityDomain;
import org.springframework.security.core.GrantedAuthority;

import java.io.Serial;

@Builder
public class UserAuthorityDto implements GrantedAuthority {

  @Serial
  private static final long serialVersionUID = 5151585071993551938L;

  private final AuthorityDomain authorityDomain;

  @Override
  public String getAuthority() {
    return "ROLE_" + authorityDomain.getName();
  }
}
