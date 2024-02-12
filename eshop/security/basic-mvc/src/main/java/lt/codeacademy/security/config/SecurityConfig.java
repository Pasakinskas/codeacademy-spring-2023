package lt.codeacademy.security.config;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class SecurityConfig {

  private final DataSource dataSource;
  private final UserDetailsService userDetailsService;
  private final PasswordEncoder passwordEncoder;

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    return http
      .authorizeHttpRequests(authorize -> authorize
        .requestMatchers(
          "/",
          "/products/**",  // changed from /products to /products/** for test security in controller level
          "/cart/**",
          "/users/**",
          "/error/**"
        ).permitAll()
        .anyRequest()
        .authenticated())
      .formLogin(loginConfigure -> loginConfigure
        .permitAll()
        .loginPage("/login")                //GET - the login form
        .loginProcessingUrl("/login")       //Specifies the URL to validate the credentials.
        .defaultSuccessUrl("/products", true)
        .usernameParameter("loginEmail")    //The HTTP parameter to look for the username
        .passwordParameter("loginPassword") //The HTTP parameter to look for the password
      )
      .logout(logoutConfigure -> logoutConfigure
        .logoutUrl("/logout")
        .logoutSuccessUrl("/")
        .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
        .permitAll()
      )
      .build();
  }

  @Bean
  public WebSecurityCustomizer webSecurityCustomizer() {
    return web -> web.ignoring()
      .requestMatchers(
        PathRequest.toH2Console(),
        PathRequest.toStaticResources().atCommonLocations()
      );
  }

  @Bean
  public AuthenticationProvider authenticationProvider() {
    final DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
    authenticationProvider.setUserDetailsService(userDetailsService);
    authenticationProvider.setPasswordEncoder(passwordEncoder);

    return authenticationProvider;
  }

}
