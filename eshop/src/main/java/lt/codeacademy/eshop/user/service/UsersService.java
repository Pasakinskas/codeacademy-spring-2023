package lt.codeacademy.eshop.user.service;


import lombok.RequiredArgsConstructor;
import lt.codeacademy.eshop.user.dto.UserDto;
import lt.codeacademy.eshop.user.pojo.User;
import lt.codeacademy.eshop.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsersService implements UserDetailsService {

  private final UserRepository userRepository;
//  private final PasswordEncoder passwordEncoder;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    return userRepository.findUserByEmail(username)
      .orElseThrow(() -> new UsernameNotFoundException("'" + username + "' not found!"));
  }

  public void register(UserDto userDto) {
    userRepository.save(
      User.builder()
        .name(userDto.getName())
        .surname(userDto.getSurname())
        .email(userDto.getEmail())
        .phoneNumber(userDto.getPhoneNumber())
        .zipCode(userDto.getZipCode())
        .password(new BCryptPasswordEncoder().encode(userDto.getPassword()))
        .build()
    );
  }
}
