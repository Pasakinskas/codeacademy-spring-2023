package lt.codeacademy.security.dto;

import lombok.Builder;
import lt.codeacademy.security.core.domain.UserDomain;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serial;
import java.util.Collection;
import java.util.stream.Collectors;

@Builder
public class UserPrincipalDto implements UserDetails {

  @Serial
  private static final long serialVersionUID = 7898695231712150370L;

  UserDomain userDomain;

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return userDomain.getAuthorities().stream()
      .map(authorityDomain -> UserAuthorityDto.builder()
        .authorityDomain(authorityDomain)
        .build())
      .collect(Collectors.toSet());
  }

  @Override
  public String getPassword() {
    return userDomain.getPassword();
  }

  @Override
  public String getUsername() {
    return userDomain.getEmail();
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }

  public String getFullName() {
    return userDomain.getName() + ' ' + userDomain.getSurname();
  }
}
