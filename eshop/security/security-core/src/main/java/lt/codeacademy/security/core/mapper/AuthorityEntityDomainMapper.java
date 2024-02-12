package lt.codeacademy.security.core.mapper;

import lt.codeacademy.security.core.domain.AuthorityDomain;
import lt.codeacademy.security.core.jpa.entity.AuthorityEntity;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class AuthorityEntityDomainMapper {

  public AuthorityDomain mapToDomain(AuthorityEntity entity) {
    return AuthorityDomain.builder()
      .id(entity.getId())
      .name(entity.getName())
      .description(entity.getDescription())
      .build();
  }

  public Set<AuthorityDomain> matToDomain(Set<AuthorityEntity> entitySet) {
    return entitySet.stream()
      .map(this::mapToDomain)
      .collect(Collectors.toSet());
  }
}
