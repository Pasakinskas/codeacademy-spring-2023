package lt.codeacademy.eshop.cart;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/cart")
@SessionAttributes("cartSession")
public class CartController {

  @GetMapping
  public String openCart(HttpServletRequest request, Model model) {
    model.addAttribute("cartSessionValue", (String) request.getSession().getAttribute("cartSession"));
    return "/cart/cart";
  }

  @GetMapping("/add")
  public String addToCart(Model model) {
    model.addAttribute("cartSession", "Labas");

    return "redirect:/cart";
  }
}
