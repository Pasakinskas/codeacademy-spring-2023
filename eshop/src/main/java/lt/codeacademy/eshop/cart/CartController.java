package lt.codeacademy.eshop.cart;

import java.util.List;

import jakarta.servlet.http.HttpServletRequest;
import lt.codeacademy.eshop.product.dto.ProductDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/cart")
@SessionAttributes("cartSession")
public class CartController {

  @ModelAttribute("cartSession")
  public List<ProductDto> createDefaultCartSession() {
    return List.of(ProductDto.builder()
      .name("Testas")
      .build());
  }

  @GetMapping
  public String openCart() {
    return "/cart/cart";
  }

}
