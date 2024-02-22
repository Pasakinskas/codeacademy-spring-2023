package lt.codeacademy.eshop.security.provider;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import lt.codeacademy.eshop.security.dto.UserPrincipalDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class JwtProvider {

  private final static Date NOW = new Date();
  public static final String ROLES_CLAIM = "roles";
  public static final String ESHOP_API = "eshop-api";

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
      .withIssuer(ESHOP_API)
      .withAudience(ESHOP_API)
      .withExpiresAt(new Date(NOW.getTime() + tokenValidityInMillis))
      .withIssuedAt(NOW)
      .withHeader(headerMap)
      .withSubject(principalDto.getUsername())
      .withClaim(ROLES_CLAIM, principalDto.getAuthorities().stream()
        .map(GrantedAuthority::getAuthority)
        .collect(Collectors.toList()))
      .sign(createAlgorithmBySecretKey());

    return token;
  }

  public Authentication parseToken(String token) {
    // validate token by secret key
    final DecodedJWT decodedJWT;
    try {
      final Algorithm algorithm = createAlgorithmBySecretKey();

      final JWTVerifier verifier = JWT.require(algorithm)
        // specify any specific claim validations
        .withIssuer(ESHOP_API)
        // reusable verifier instance
        .build();

      decodedJWT = verifier.verify(token.trim());

      if (decodedJWT != null) {
        final String principalAsUsername = decodedJWT.getSubject();
        final Claim rolesClaim = decodedJWT.getClaim(ROLES_CLAIM);
        final List<SimpleGrantedAuthority> authorityList = rolesClaim.asList(SimpleGrantedAuthority.class);

        // and fill UsernamePasswordAuthenticationToken with required parameters
        return new UsernamePasswordAuthenticationToken(principalAsUsername, null, authorityList);
      }
    } catch (JWTVerificationException exception){
      exception.printStackTrace();
    }

    return null;
  }

  private Algorithm createAlgorithmBySecretKey() {
    return Algorithm.HMAC512(secretKey);
  }
}
