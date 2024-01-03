package lt.codeacademy.eshop;

import lt.codeacademy.eshop.product.Product;
import lt.codeacademy.eshop.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class FirstController {

  private ProductService productService;

  @Autowired
  public FirstController(ProductService productService) {
    this.productService = productService;
  }

  @GetMapping("/products/create")
  public String sayHelloToCustomer(Model model) {
    model.addAttribute("product", new Product());
    return "product";
  }

  @PostMapping("/products/create")
  public String createAProduct(Product product) {

    productService.saveProduct(product);
    System.out.println("currently in the database");
    productService.getAllProducts().forEach(System.out::println);
    return "hello";
  }
}
