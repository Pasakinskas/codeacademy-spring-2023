package lt.codeacademy.eshop.common.cart.dto;

import java.math.BigDecimal;

import lombok.Builder;
import lombok.Getter;
import lt.codeacademy.eshop.common.cart.calculator.CartItemCalculator;
import lt.codeacademy.eshop.common.product.dto.ProductDto;

@Builder
@Getter
public class CartItemDto {

  private final ProductDto productDto;
  private int quantity;

  public void incrementQuantity() {
    quantity++;
  }

  public BigDecimal getTotalItemPrice() {
    return CartItemCalculator.calculateTotal(this);
  }
}
