package lt.codeacademy.eshop.security.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class AuthorityDomain {

  private Long id;
  private String name;
  private String description;

}
