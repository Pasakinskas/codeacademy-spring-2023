package lt.codeacademy.eshop.api.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

  @Bean
  public OpenAPI customOpenApi() {
    return new OpenAPI()
      .info(getInfo());
  }

  private Info getInfo() {
    return new Info()
      .version("1.0.0")
      .title("Eshop Restfull Api Documentation")
      .description("This is documentation using swagger and openApi")
      .contact(new Contact().url("www.eshop.lt").name("Eshop UAB"))
      .license(new License().name("No licence. Free to use"));
  }
}
