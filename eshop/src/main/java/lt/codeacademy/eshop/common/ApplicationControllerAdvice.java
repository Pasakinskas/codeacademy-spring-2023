package lt.codeacademy.eshop.common;

import lt.codeacademy.eshop.product.exception.ProductNotFoundException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApplicationControllerAdvice {

  @ExceptionHandler
  public String productNotFound(ProductNotFoundException e, Model model) {
    model.addAttribute("productUUID", e.getProductUUID());
    return "product/error/productNotFound";
  }


}
