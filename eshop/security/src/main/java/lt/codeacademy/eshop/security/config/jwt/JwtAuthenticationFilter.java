package lt.codeacademy.eshop.security.config.jwt;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lt.codeacademy.eshop.security.dto.LoginRequest;
import lt.codeacademy.eshop.security.provider.JwtProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.io.IOException;

public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

  private final ObjectMapper objectMapper;
  private final JwtProvider jwtProvider;

  public JwtAuthenticationFilter(AuthenticationManager authenticationManager,
                                 ObjectMapper objectMapper,
                                 JwtProvider jwtProvider) {
    super(authenticationManager);
    this.objectMapper = objectMapper;
    this.jwtProvider = jwtProvider;
  }

  @Override
  public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
    try {
      LoginRequest loginRequest = objectMapper.readValue(request.getReader(), LoginRequest.class);

      UsernamePasswordAuthenticationToken authRequest =
        UsernamePasswordAuthenticationToken.unauthenticated(loginRequest.username(), loginRequest.password());

      // Allow subclasses to set the "details" property
      setDetails(request, authRequest);
      return this.getAuthenticationManager().authenticate(authRequest);
    } catch (IOException e) {
      throw new BadCredentialsException("Unable to parse payload credentials");
    }
  }

  @Override
  protected void successfulAuthentication(HttpServletRequest request,
                                          HttpServletResponse response,
                                          FilterChain chain,
                                          Authentication authResult)
    throws IOException, ServletException {
    SecurityContextHolder.getContext().setAuthentication(authResult);

    response.addHeader(HttpHeaders.AUTHORIZATION, jwtProvider.getToken(authResult));

    chain.doFilter(request, response);
  }
}
