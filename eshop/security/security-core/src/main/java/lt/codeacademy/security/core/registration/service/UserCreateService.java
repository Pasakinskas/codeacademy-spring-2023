package lt.codeacademy.security.core.registration.service;

import lombok.RequiredArgsConstructor;
import lt.codeacademy.security.core.registration.dto.UserRegistrationDto;
import lt.codeacademy.security.core.cases.UsersRegistrationService;
import lt.codeacademy.security.core.domain.UserDomain;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserCreateService {

  private final UsersRegistrationService usersRegistrationService;

  public void createUser(UserRegistrationDto userRegistrationDto) {
    usersRegistrationService.register(UserDomain.builder()
      .name(userRegistrationDto.getName())
      .surname(userRegistrationDto.getSurname())
      .email(userRegistrationDto.getEmail())
      .phoneNumber(userRegistrationDto.getPhoneNumber())
      .zipCode(userRegistrationDto.getZipCode())
      .password(userRegistrationDto.getPassword())
      .build());
  }
}
