package lt.codeacademy.eshop.cart.service;

import java.util.UUID;

import lombok.RequiredArgsConstructor;
import lt.codeacademy.eshop.cart.dto.CartDto;
import lt.codeacademy.eshop.product.dto.ProductDto;
import lt.codeacademy.eshop.product.service.ProductService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CartService {

  private final ProductService productService;

  public void addProductToCart(final UUID productId, final CartDto cart) {
    final ProductDto productDto = productService.getProductByUUID(productId);

    cart.add(productDto);
  }
}
