package lt.codeacademy.eshop.product.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lt.codeacademy.eshop.product.dto.ProductDto;
import lt.codeacademy.eshop.product.service.ProductService;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

  @PostMapping("/products")
  public ResponseEntity<ProductDto> createAProduct(@RequestBody @Valid ProductDto productDto) {
    var savedProduct = productService.save(productDto);
    return ResponseEntity.status(HttpStatusCode.valueOf(201)).body(savedProduct);
  }
}
