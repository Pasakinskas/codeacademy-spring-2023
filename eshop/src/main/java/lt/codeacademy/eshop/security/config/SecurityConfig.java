package lt.codeacademy.eshop.security.config;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@Profile("!unsecure")
public class SecurityConfig {

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    return http
      .authorizeHttpRequests(authorize -> authorize
        .requestMatchers(
          "/",
          "/products",
          "/cart/**",
          "/users/**"
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
  public UserDetailsService inMemoryUserDetailsService() {
    final UserDetails adminUser = User.builder()
      .username("admin@eshop.lt")
      // Steps how to encode password:
      // 1. Open PasswordEncoderFactories and look for bcrypt, we will see that bcypt use BCryptPasswordEncoder class
      // 2. Go to BCryptPasswordEncoder implementation and add break point on 129 line
      // 3. Run application in debug mode and when stopped press Alt + F8 (Evaluation window should appear)
      // 4. Write there this.encode("your password") and press EVALUATE button
      // or skip all steps and use https://bcrypt-generator.com/ :)))
      .password("{bcrypt}$2a$10$2kRxk7JsJr/VEVqs15WwpOJPjiuAQmPTj09zZofU5X4IZAL6HCwh.")  // pass is admin, look PasswordEncoderFactories for bcrypt
      .roles("ADMIN", "USER")
      .build();
    final UserDetails userUser = User.builder()
      .username("user@eshop.lt")
      .password("{noop}user")   // look PasswordEncoderFactories
      .roles("USER")
      .build();

    return new InMemoryUserDetailsManager(adminUser, userUser);
  }
}
