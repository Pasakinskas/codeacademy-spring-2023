package lt.codeacademy.eshop.mvc;

import lt.codeacademy.eshop.common.product.exception.ProductNotFoundException;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;

@ControllerAdvice
public class ApplicationControllerAdvice {

  @ExceptionHandler
  public String productNotFound(ProductNotFoundException e, Model model) {
    model.addAttribute("productUUID", e.getProductUUID());
    return "product/error/productNotFound";
  }

  @ExceptionHandler
  public String otherErrors(Exception e) {
    throw new RuntimeException(e);
  }

  @InitBinder
  public void initBinder(WebDataBinder webDataBinder) {
    StringTrimmerEditor trimmerEditor = new StringTrimmerEditor(true);
    webDataBinder.registerCustomEditor(String.class, trimmerEditor);
  }
}
