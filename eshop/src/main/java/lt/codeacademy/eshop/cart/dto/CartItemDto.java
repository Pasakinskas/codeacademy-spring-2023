package lt.codeacademy.eshop.cart.dto;

import lombok.Builder;
import lombok.Getter;
import lt.codeacademy.eshop.product.dto.ProductDto;

@Builder
@Getter
public class CartItemDto {

  private final ProductDto productDto;
}
