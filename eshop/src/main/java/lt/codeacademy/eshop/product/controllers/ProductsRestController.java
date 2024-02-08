package lt.codeacademy.eshop.product.controllers;

import lombok.RequiredArgsConstructor;
import lt.codeacademy.eshop.product.dto.ProductDto;
import lt.codeacademy.eshop.product.service.ProductService;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductsRestController {

  private final ProductService productService;

  @GetMapping("/products")
  public List<ProductDto> getAllProducts() {
    return productService.getAllProductsPage(Pageable.ofSize(100))
      .stream().toList();
  }
}
