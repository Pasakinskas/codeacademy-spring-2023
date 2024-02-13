package lt.codeacademy.eshop.security.mapper;

import lombok.RequiredArgsConstructor;
import lt.codeacademy.eshop.security.domain.UserDomain;
import lt.codeacademy.eshop.security.jpa.entity.User;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserEntityDomainMapper {

  private final AuthorityEntityDomainMapper authorityEntityDomainMapper;

  public UserDomain mapToDomain(User entity) {
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
