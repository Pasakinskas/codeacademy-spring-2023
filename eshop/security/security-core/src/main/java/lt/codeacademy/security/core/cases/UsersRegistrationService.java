package lt.codeacademy.security.core.cases;

import lombok.RequiredArgsConstructor;
import lt.codeacademy.security.core.domain.UserDomain;
import lt.codeacademy.security.core.jpa.entity.AuthorityEntity;
import lt.codeacademy.security.core.jpa.entity.UserEntity;
import lt.codeacademy.security.core.jpa.repository.AuthorityRepository;
import lt.codeacademy.security.core.jpa.repository.UserRepository;
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
    final Set<AuthorityEntity> authorities = authorityRepository.findAll().stream()
      .filter(authority -> authority.getName().equals("USER"))
      .collect(Collectors.toSet());

    userRepository.save(
      UserEntity.builder()
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
