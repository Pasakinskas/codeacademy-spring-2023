package lt.codeacademy.eshop.user.service;


import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Set;
import java.util.stream.Collectors;

import lombok.RequiredArgsConstructor;
import lt.codeacademy.eshop.user.dto.UserDto;
import lt.codeacademy.eshop.user.pojo.Authority;
import lt.codeacademy.eshop.user.pojo.User;
import lt.codeacademy.eshop.user.repository.AuthorityRepository;
import lt.codeacademy.eshop.user.repository.UserRepository;
import org.h2.jdbc.JdbcSQLIntegrityConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
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
        .password(new BCryptPasswordEncoder().encode(userDto.getPassword()))
        .authorities(authorities)
        .build()
    );
  }
}
