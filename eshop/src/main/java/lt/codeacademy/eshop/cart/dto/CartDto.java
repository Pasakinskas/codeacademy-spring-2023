package lt.codeacademy.eshop.cart.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lt.codeacademy.eshop.product.dto.ProductDto;

@Getter
public class CartDto {

  private final List<CartItemDto> cartItems = new ArrayList<>();

  public void add(final ProductDto productDto) {
    cartItems.add(CartItemDto.builder()
      .productDto(productDto)
      .quantity(1)
      .build());
  }
}
