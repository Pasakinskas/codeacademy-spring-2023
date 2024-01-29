package lt.codeacademy.eshop.cart;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lt.codeacademy.eshop.product.dto.ProductDto;
import lt.codeacademy.eshop.product.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/cart")
@SessionAttributes("cartSession")
@RequiredArgsConstructor
public class CartController {

  private final ProductService productService;

  @ModelAttribute("cartSession")
  public List<ProductDto> createDefaultCartSession() {
    return new ArrayList<>();
  }

  @GetMapping
  public String openCart() {
    return "/cart/cart";
  }

  @PostMapping("/{productId}")
  public String addToCart(@PathVariable UUID productId,
                          @ModelAttribute("cartSession")  List<ProductDto> cart) {
    final ProductDto productDto = productService.getProductByUUID(productId);
    cart.add(productDto);

    return "redirect:/products";
  }

}
