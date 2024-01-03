package lt.codeacademy.eshop;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class FirstController {

  @GetMapping("/products/create")
  public String sayHelloToCustomer(Model model) {
    model.addAttribute("product", new Product());
    return "product";
  }

  @PostMapping("/products/create")
  public String createAProduct(Product product) {

    System.out.println(product);
    return "hello";
  }
}
