package lt.codeacademy.eshop.config;

import com.github.javafaker.Faker;
import lombok.RequiredArgsConstructor;
import lt.codeacademy.eshop.product.Product;
import lt.codeacademy.eshop.product.ProductService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class ProductDataMockConfig {

  private static final int MAX_COUNT = 10;

  private final ProductService productService;

  @Bean
  public Void initProducts() {
    var count = 0;
    final Faker faker = new Faker();
    while (MAX_COUNT >= count) {
      productService.saveProduct(
        new Product(
          faker.food().fruit(),
          faker.number().numberBetween(2, 99),
          faker.number().numberBetween(1, 100)));
      count++;
    }
    return null;
  }
}
