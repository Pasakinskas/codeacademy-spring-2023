package lt.codeacademy.eshop.security.cases;

import lombok.RequiredArgsConstructor;
import lt.codeacademy.eshop.security.jpa.entity.Authority;
import lt.codeacademy.eshop.security.jpa.entity.User;
import lt.codeacademy.eshop.security.jpa.repository.AuthorityRepository;
import lt.codeacademy.eshop.security.jpa.repository.UserRepository;
import lt.codeacademy.eshop.security.domain.UserDomain;
import lt.codeacademy.eshop.security.service.Encoder;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UsersRegistrationService {

  private final UserRepository userRepository;
  private final AuthorityRepository authorityRepository;
  private final Encoder encoder;

  public void register(UserDomain userDomain) throws DataIntegrityViolationException {
    final Set<Authority> authorities = authorityRepository.findAll().stream()
      .filter(authority -> authority.getName().equals("USER"))
      .collect(Collectors.toSet());

    userRepository.save(
      User.builder()
        .name(userDomain.getName())
        .surname(userDomain.getSurname())
        .email(userDomain.getEmail())
        .phoneNumber(userDomain.getPhoneNumber())
        .zipCode(userDomain.getZipCode())
        .password(encoder.encode(userDomain.getPassword()))
        .authorities(authorities)
        .build()
    );
  }
}
