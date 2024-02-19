package lt.codeacademy.eshop.security.config.jwt;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lt.codeacademy.eshop.security.config.basic.ApplicationUsersPropertyConfig;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Slf4j
@Profile("secure-rest-jwt")
@Configuration
@EnableWebSecurity
@EnableConfigurationProperties(ApplicationUsersPropertyConfig.class)
@RequiredArgsConstructor
@EnableMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class SecurityRestJwtConfig {

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
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

      .build();
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return PasswordEncoderFactories.createDelegatingPasswordEncoder();
  }

}
