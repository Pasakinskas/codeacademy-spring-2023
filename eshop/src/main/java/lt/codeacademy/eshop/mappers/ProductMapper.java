package lt.codeacademy.eshop.mappers;

import lt.codeacademy.eshop.product.Product;
import lt.codeacademy.eshop.product.dto.ProductDto;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

  public ProductDto toProductDto(Product product) {
    return new ProductDto(
      product.getProductId(),
      product.getName(),
      product.getPrice(),
      product.getAmount()
    );
  }
}
