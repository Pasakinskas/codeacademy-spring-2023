package lt.codeacademy.eshop.security.config.basic;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.List;

@Slf4j
@Profile("secure-rest-basic")
@Configuration
@EnableWebSecurity
@EnableConfigurationProperties(ApplicationUsersPropertyConfig.class)
@RequiredArgsConstructor
@EnableMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class SecurityRestBasicConfig {

  private final ApplicationUsersPropertyConfig applicationUsers;

  @Bean
  public PasswordEncoder passwordEncoder() {
    return PasswordEncoderFactories.createDelegatingPasswordEncoder();
  }

  @Bean
  public UserDetailsService inMemoryUserDetailsService() {
    final List<UserDetails> users = applicationUsers.getUsers().stream()
      .map(globalUser -> {
        log.info("----==== Imported globaly users {}", globalUser);

        return User.builder()
          .username(globalUser.getUsername())
          .password(globalUser.getPassword())  // look PasswordEncoderFactories
          .roles(globalUser.getRoles())
          .build();
      })
      .toList();

    return new InMemoryUserDetailsManager(users);
  }
}
