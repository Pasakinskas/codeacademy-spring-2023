package lt.codeacademy.eshop.cart;

import jakarta.servlet.http.HttpServletRequest;
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

  @GetMapping
  public String openCart() {
    return "/cart/cart";
  }

  @GetMapping("/add")
  public String addToCart(Model model) {
    model.addAttribute("cartSession", "Labas");

    return "redirect:/cart";
  }
}
