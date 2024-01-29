package lt.codeacademy.eshop.cart.service;

import java.util.Optional;
import java.util.UUID;

import lombok.RequiredArgsConstructor;
import lt.codeacademy.eshop.cart.dto.CartDto;
import lt.codeacademy.eshop.cart.dto.CartItemDto;
import lt.codeacademy.eshop.product.dto.ProductDto;
import lt.codeacademy.eshop.product.service.ProductService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CartService {

  private final ProductService productService;

  public void addProductToCartByProductId(final UUID productId, final CartDto cart) {
    this.getCartItem(productId, cart)
      .ifPresentOrElse(
			  CartItemDto::incrementQuantity,
        () -> addProductToCart(productId, cart)
      );
  }

  private Optional<CartItemDto> getCartItem(UUID productId, CartDto cart) {
    return cart.getCartItems().stream()
      .filter(cartItemDto -> cartItemDto.getProductDto().getProductId().equals(productId))
      .findAny();
  }

  private void addProductToCart(final UUID productId, final CartDto cart) {
    final ProductDto productDto = productService.getProductByUUID(productId);
    cart.add(productDto);
  }
}
