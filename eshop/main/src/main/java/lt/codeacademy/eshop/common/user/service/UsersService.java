package lt.codeacademy.eshop.common.user.service;


import lombok.RequiredArgsConstructor;
import lt.codeacademy.eshop.jpa.repositories.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsersService implements UserDetailsService {

  private final UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    return userRepository.findUserByEmailWithAuthorities(username)
      .orElseThrow(() -> new UsernameNotFoundException("'" + username + "' not found!"));
  }
}
