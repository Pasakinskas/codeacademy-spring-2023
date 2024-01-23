package lt.codeacademy.eshop.product.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ProductCategoryDto {

  private final Long id;
  private final String name;
}
