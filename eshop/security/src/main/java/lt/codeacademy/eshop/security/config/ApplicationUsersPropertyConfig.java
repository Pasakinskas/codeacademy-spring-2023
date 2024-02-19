package lt.codeacademy.eshop.security.config;

import lombok.Getter;
import lt.codeacademy.eshop.security.domain.GlobalUser;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.ArrayList;
import java.util.List;

@ConfigurationProperties("global")
public class ApplicationUsersPropertyConfig {

  @Getter
  private final List<GlobalUser> users = new ArrayList<>();
}
