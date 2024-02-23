package lt.codeacademy.eshop.api.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;

@Configuration
public class OpenApiConfig {

  @Bean
  public OpenAPI customOpenApi() {
    return new OpenAPI()
      .info(getInfo())
      .components(getComponents());
  }

  private Info getInfo() {
    return new Info()
      .version("1.0.0")
      .title("Eshop Restfull Api Documentation")
      .description("This is documentation using swagger and openApi")
      .contact(new Contact().url("www.eshop.lt").name("Eshop UAB"))
      .license(new License().name("No licence. Free to use"));
  }

  private Components getComponents() {
    SecurityScheme securitySchemeBearer = new SecurityScheme()
      .name(HttpHeaders.AUTHORIZATION)
      .description("Bearer authorization. To get required key you should call /login")
      .type(SecurityScheme.Type.HTTP)
      .scheme("bearer")
      .bearerFormat("JWT");

    return new Components()
      .addSecuritySchemes(securitySchemeBearer.getName(), securitySchemeBearer);
  }
}
