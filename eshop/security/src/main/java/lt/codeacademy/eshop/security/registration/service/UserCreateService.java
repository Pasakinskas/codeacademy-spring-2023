package lt.codeacademy.eshop.security.registration.service;

import lombok.RequiredArgsConstructor;
import lt.codeacademy.eshop.security.cases.UsersRegistrationService;
import lt.codeacademy.eshop.security.domain.UserDomain;
import lt.codeacademy.eshop.security.registration.dto.UserRegistrationDto;
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
