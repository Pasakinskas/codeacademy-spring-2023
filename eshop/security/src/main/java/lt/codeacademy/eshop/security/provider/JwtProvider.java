package lt.codeacademy.eshop.security.provider;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import lt.codeacademy.eshop.security.dto.UserPrincipalDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class JwtProvider {

  private final static Date NOW = new Date();

  @Value("#{${spring.security.jwt.validity-time} * 60 * 1000}")
  private long tokenValidityInMillis;

  @Value("${spring.security.jwt.secret-key}")
  private byte[] secretKey;

  public static Map<String, Object> headerMap;

  static {
    headerMap = new HashMap<>();
    headerMap.put("typ", "JWT");
  }

  public String getToken(Authentication authentication) {
    final UserPrincipalDto principalDto = (UserPrincipalDto) authentication.getPrincipal();

    final String token = JWT.create()
      .withIssuer("eshop-api")
      .withAudience("eshop-api")
      .withExpiresAt(new Date(NOW.getTime() + tokenValidityInMillis))
      .withIssuedAt(NOW)
      .withHeader(headerMap)
      .withSubject(principalDto.getUsername())
      .withClaim("roles", principalDto.getAuthorities().stream()
        .map(GrantedAuthority::getAuthority)
        .collect(Collectors.toList()))
      .sign(Algorithm.HMAC512(secretKey));

    return token;
  }

}
