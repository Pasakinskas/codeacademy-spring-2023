package lt.codeacademy.eshop.security.config.jwt;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lt.codeacademy.eshop.security.config.ApplicationUsersPropertyConfig;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.List;

@Slf4j
@Profile("secure-rest-jwt")
@Configuration
@EnableWebSecurity
@EnableConfigurationProperties(ApplicationUsersPropertyConfig.class)
@RequiredArgsConstructor
@EnableMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class SecurityRestJwtConfig {

  private final ObjectMapper objectMapper;
  private final ApplicationUsersPropertyConfig applicationUsers;

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http,
                                                 AuthenticationManager authenticationManager) throws Exception {
    return http
      // Disable csrf as not important for rest endpoints
      .csrf(AbstractHttpConfigurer::disable)

      // turn on httpBasic of InMemoryUserDetailsManager
      .httpBasic(httpBasicConfigurer -> httpBasicConfigurer.init(http))

      // set session management to stateless
      .sessionManagement(sessionManagementConfigurer ->
        sessionManagementConfigurer.sessionCreationPolicy(SessionCreationPolicy.STATELESS))

      // set authorization request access for whole requests
      .authorizeHttpRequests(authConfigurer -> authConfigurer.anyRequest().authenticated())
      .addFilter(new JwtAuthenticationFilter(authenticationManager, objectMapper))
      .build();
  }

  @Bean
  public AuthenticationManager authenticationManager(UserDetailsService userDetailsService,
                                                     PasswordEncoder passwordEncoder) {
    DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
    authenticationProvider.setUserDetailsService(userDetailsService);
    authenticationProvider.setPasswordEncoder(passwordEncoder);

    return new ProviderManager(authenticationProvider);
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

  @Bean
  public PasswordEncoder passwordEncoder() {
    return PasswordEncoderFactories.createDelegatingPasswordEncoder();
  }

}
