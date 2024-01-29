package lt.codeacademy.eshop.cart.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lt.codeacademy.eshop.cart.dto.CartDto;
import lt.codeacademy.eshop.cart.service.CartService;
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

  private final CartService cartService;

  @ModelAttribute("cartSession")
  public CartDto createDefaultCartSession() {
    return new CartDto();
  }

  @GetMapping
  public String openCart() {
    return "/cart/cart";
  }

  @PostMapping("/{productId}")
  public String addToCart(@PathVariable UUID productId,
                          @ModelAttribute("cartSession") CartDto cart) {
    cartService.addProductToCart(productId, cart);

    return "redirect:/products";
  }

}
