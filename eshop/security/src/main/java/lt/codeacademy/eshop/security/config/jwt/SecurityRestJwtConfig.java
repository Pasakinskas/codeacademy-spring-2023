package lt.codeacademy.eshop.security.config.jwt;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lt.codeacademy.eshop.security.config.CommonConfig;
import lt.codeacademy.eshop.security.provider.JwtProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Slf4j
@Profile("secure-rest-jwt")
@Configuration
@RequiredArgsConstructor
@EnableMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class SecurityRestJwtConfig extends CommonConfig {

  private final ObjectMapper objectMapper;
  private final UserDetailsService userDetailsService;
  private final JwtProvider jwtProvider;

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http,
                                                 AuthenticationManager authenticationManager) throws Exception {
    return http
      .authorizeHttpRequests(authRequestConfigurer -> authRequestConfigurer.requestMatchers(
        "/login",
        "/swagger-ui.html",
        "/swagger-ui/**",
        "/v3/api-docs/**"
      ).permitAll()
        .anyRequest().authenticated())

      // Disable csrf as not important for rest endpoints
      .csrf(AbstractHttpConfigurer::disable)

      // turn on httpBasic of InMemoryUserDetailsManager
      .httpBasic(httpBasicConfigurer -> httpBasicConfigurer.init(http))

      // set session management to stateless
      .sessionManagement(sessionManagementConfigurer ->
        sessionManagementConfigurer.sessionCreationPolicy(SessionCreationPolicy.STATELESS))

      // set authorization request access for whole requests
      .addFilter(new JwtAuthenticationFilter(authenticationManager, objectMapper, jwtProvider))
      .addFilterBefore(new JwtAuthorizationFilter(jwtProvider), UsernamePasswordAuthenticationFilter.class)
      .build();
  }

  @Bean
  public AuthenticationManager authenticationManager(AuthenticationProvider authenticationProvider) {
    return new ProviderManager(authenticationProvider);
  }

  @Bean
  public AuthenticationProvider authenticationProvider() {
    final DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
    authenticationProvider.setUserDetailsService(userDetailsService);
    authenticationProvider.setPasswordEncoder(passwordEncoder());

    return authenticationProvider;
  }
}
