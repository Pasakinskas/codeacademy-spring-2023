package lt.codeacademy.eshop.common.user.service;


import java.util.Set;
import java.util.stream.Collectors;

import lombok.RequiredArgsConstructor;
import lt.codeacademy.eshop.common.user.dto.UserDto;
import lt.codeacademy.eshop.jpa.entities.Authority;
import lt.codeacademy.eshop.jpa.entities.User;
import lt.codeacademy.eshop.jpa.repositories.AuthorityRepository;
import lt.codeacademy.eshop.jpa.repositories.UserRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsersRegistrationService {

  private final UserRepository userRepository;
  private final AuthorityRepository authorityRepository;
  private final PasswordEncoder passwordEncoder;

  public void register(UserDto userDto) throws DataIntegrityViolationException {
    final Set<Authority> authorities = authorityRepository.findAll().stream()
      .filter(authority -> authority.getName().equals("USER"))
      .collect(Collectors.toSet());

    userRepository.save(
      User.builder()
        .name(userDto.getName())
        .surname(userDto.getSurname())
        .email(userDto.getEmail())
        .phoneNumber(userDto.getPhoneNumber())
        .zipCode(userDto.getZipCode())
        .password(passwordEncoder.encode(userDto.getPassword()))
        .authorities(authorities)
        .build()
    );
  }
}
