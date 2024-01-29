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
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    cartService.addProductToCartByProductId(productId, cart);

    return "redirect:/products";
  }

  @PostMapping
  public String order(SessionStatus sessionStatus, RedirectAttributes redirectAttributes) {
    //TODO: save into DB or do other things with cart data

    sessionStatus.setComplete();

    redirectAttributes.addFlashAttribute("successMessageFlashAttr", "Order created successfully!");

    return "redirect:/products";
  }

}
