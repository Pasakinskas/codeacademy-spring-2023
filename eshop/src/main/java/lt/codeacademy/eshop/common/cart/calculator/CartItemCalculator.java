package lt.codeacademy.eshop.common.cart.calculator;

import java.math.BigDecimal;

import lt.codeacademy.eshop.common.cart.dto.CartItemDto;
import org.springframework.stereotype.Component;

@Component
public class CartItemCalculator {

  public static BigDecimal calculateTotal(final CartItemDto cartItemDto) {
    return cartItemDto.getProductDto().getPrice().multiply(BigDecimal.valueOf(cartItemDto.getQuantity()));
  }
}
