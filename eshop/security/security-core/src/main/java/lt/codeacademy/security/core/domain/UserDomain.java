package lt.codeacademy.security.core.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Set;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class UserDomain {

  private Long id;
  private String name;
  private String surname;
  private String email;
  private String password;
  private String zipCode;
  private String phoneNumber;
  private Set<AuthorityDomain> authorities;
}
