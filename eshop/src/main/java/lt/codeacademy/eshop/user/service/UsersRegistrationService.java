package lt.codeacademy.eshop.user.service;


import java.util.Set;

import lombok.RequiredArgsConstructor;
import lt.codeacademy.eshop.user.dto.UserDto;
import lt.codeacademy.eshop.user.pojo.Authority;
import lt.codeacademy.eshop.user.pojo.User;
import lt.codeacademy.eshop.user.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsersRegistrationService {

  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;

  public void register(UserDto userDto) {
    userRepository.save(
      User.builder()
        .name(userDto.getName())
        .surname(userDto.getSurname())
        .email(userDto.getEmail())
        .phoneNumber(userDto.getPhoneNumber())
        .zipCode(userDto.getZipCode())
        .password(new BCryptPasswordEncoder().encode(userDto.getPassword()))
        .authorities(Set.of(
          Authority.builder()
            .name("USER")
            .build()))
        .build()
    );
  }
}
