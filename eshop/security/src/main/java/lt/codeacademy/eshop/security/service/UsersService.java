package lt.codeacademy.eshop.security.service;

import lombok.RequiredArgsConstructor;
import lt.codeacademy.eshop.security.domain.UserDomain;
import lt.codeacademy.eshop.security.dto.UserPrincipalDto;
import lt.codeacademy.eshop.security.jpa.repository.UserRepository;
import lt.codeacademy.eshop.security.mapper.UserEntityDomainMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsersService implements UserDetailsService {

  private final UserRepository userRepository;
  private final UserEntityDomainMapper userEntityDomainMapper;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    final UserDomain userDomain = userRepository.findUserByEmailWithAuthorities(username)
      .map(userEntityDomainMapper::mapToDomain)
      .orElseThrow(() -> new UsernameNotFoundException("'" + username + "' not found!"));

    return UserPrincipalDto.builder()
      .userDomain(userDomain)
      .build();
  }
}
