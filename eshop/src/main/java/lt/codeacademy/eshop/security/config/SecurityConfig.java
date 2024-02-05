package lt.codeacademy.eshop.security.config;

import javax.sql.DataSource;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@Profile("!unsecure")
@RequiredArgsConstructor
public class SecurityConfig {

  private final DataSource dataSource;

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

//  @Bean
  public UserDetailsService inMemoryUserDetailsService() {
    final PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

    final UserDetails adminUser = User.builder()
      .username("admin@eshop.lt")
      .password(encoder.encode("admin"))
      .roles("ADMIN", "USER")
      .build();
    final UserDetails userUser = User.builder()
      .username("user@eshop.lt")
      .password("{noop}user")   // look PasswordEncoderFactories
      .roles("USER")
      .build();
    System.out.println(adminUser.getPassword());
    System.out.println(userUser.getPassword());

    return new InMemoryUserDetailsManager(adminUser, userUser);
  }

  @Bean
  public UserDetailsService jdbcUserDetailsService() {
    final JdbcUserDetailsManager users = new JdbcUserDetailsManager(dataSource);
    users.setUsersByUsernameQuery("select email AS username, password, TRUE as enabled FROM users WHERE email = ?");
    users.setAuthoritiesByUsernameQuery("select email AS username, 'ROLE_ADMIN' AS authority FROM users WHERE email = ?");

    return users;
  }

}
