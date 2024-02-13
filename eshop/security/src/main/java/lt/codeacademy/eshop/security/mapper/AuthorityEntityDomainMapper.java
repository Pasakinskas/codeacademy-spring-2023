package lt.codeacademy.eshop.security.mapper;

import lt.codeacademy.eshop.security.domain.AuthorityDomain;
import lt.codeacademy.eshop.security.jpa.entity.Authority;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class AuthorityEntityDomainMapper {

  public AuthorityDomain mapToDomain(Authority entity) {
    return AuthorityDomain.builder()
      .id(entity.getId())
      .name(entity.getName())
      .description(entity.getDescription())
      .build();
  }

  public Set<AuthorityDomain> matToDomain(Set<Authority> entitySet) {
    return entitySet.stream()
      .map(this::mapToDomain)
      .collect(Collectors.toSet());
  }
}
