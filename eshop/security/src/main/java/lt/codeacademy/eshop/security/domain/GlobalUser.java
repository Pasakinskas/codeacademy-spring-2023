package lt.codeacademy.eshop.security.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.StringJoiner;

@Getter
@Setter
public class GlobalUser {
  private String username;
  private String password;
  private String[] roles;

  @Override
  public String toString() {
    return new StringJoiner(", ", GlobalUser.class.getSimpleName() + "[", "]")
      .add("username='" + username + "'")
      .toString();
  }
}
