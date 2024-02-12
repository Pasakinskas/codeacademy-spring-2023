package lt.codeacademy.security.core.mapper;

import lombok.RequiredArgsConstructor;
import lt.codeacademy.security.core.domain.UserDomain;
import lt.codeacademy.security.core.jpa.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserEntityDomainMapper {

  private final AuthorityEntityDomainMapper authorityEntityDomainMapper;

  public UserDomain mapToDomain(UserEntity entity) {
    return UserDomain.builder()
      .id(entity.getId())
      .name(entity.getName())
      .surname(entity.getSurname())
      .email(entity.getEmail())
      .password(entity.getPassword())
      .authorities(authorityEntityDomainMapper.matToDomain(entity.getAuthorities()))
      .phoneNumber(entity.getPhoneNumber())
      .zipCode(entity.getZipCode())
      .build();
  }
}
