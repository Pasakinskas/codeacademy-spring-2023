package lt.codeacademy.eshop.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    return http
      .authorizeHttpRequests(authorize -> authorize
        .requestMatchers(
          "/login/**",
          "/eshop_h2/**"
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
      .csrf(csrfConfigurer -> csrfConfigurer
        .ignoringRequestMatchers("/eshop_h2/**")
      )
      .headers(headerConfigurer -> headerConfigurer
        .frameOptions(HeadersConfigurer.FrameOptionsConfig::sameOrigin)
      )
      .build();
  }
}
