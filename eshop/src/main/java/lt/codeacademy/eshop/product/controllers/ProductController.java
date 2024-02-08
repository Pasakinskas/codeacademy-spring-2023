package lt.codeacademy.eshop.product.controllers;

import java.util.List;
import java.util.Set;
import java.util.UUID;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lt.codeacademy.eshop.HttpEndpoints;
import lt.codeacademy.eshop.helper.MessageService;
import lt.codeacademy.eshop.product.dto.ProductCategoryDto;
import lt.codeacademy.eshop.product.dto.ProductDto;
import lt.codeacademy.eshop.product.service.ProductCategoryService;
import lt.codeacademy.eshop.product.service.ProductService;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Slf4j
@RequiredArgsConstructor
public class ProductController {

  private final ProductService productService;
  private final ProductCategoryService productCategoryService;
  private final MessageService messageService;

  @ResponseBody
  @GetMapping(value = "/products", produces = MediaType.APPLICATION_JSON_VALUE)
  public List<ProductDto> getAllProducts() {
    return productService.getAllProductsPage(Pageable.ofSize(100))
      .stream().toList();
  }

  @PreAuthorize("hasRole('ADMIN')")
  @GetMapping(HttpEndpoints.PRODUCTS_CREATE)
  public String getFormForCreate(Model model, String message) {
    Set<ProductCategoryDto> categories = productCategoryService.getCategories();

    model.addAttribute("categoriesDto", categories);
    model.addAttribute("productDto", ProductDto.builder().build());
    model.addAttribute("message", messageService.getTranslatedMessage(message));

    return "product/product";
  }

  @PreAuthorize("hasRole('ADMIN')")
  @GetMapping(HttpEndpoints.PRODUCTS_UPDATE)
  public String getFormForUpdate(Model model, @PathVariable UUID productId) {
    log.info("Got request for GET /products/{}/update", productId);
    model.addAttribute("productDto", productService.getProductByUUID(productId));

    return "product/product";
  }

  @PreAuthorize("hasRole('ADMIN')")
  @PostMapping(HttpEndpoints.PRODUCTS_CREATE)
  public String createAProduct(Model model, @Valid ProductDto product, BindingResult errors) {
    if (errors.hasErrors()) {
      return "product/product";
    }

    productService.saveProduct(product);

    return "redirect:/products/create?message=product.create.message.success";
  }

  @PreAuthorize("hasRole('ADMIN')")
  @PostMapping(HttpEndpoints.PRODUCTS_UPDATE)
  public String updateProduct(Model model, Pageable pageable, ProductDto productDto, @PathVariable UUID productId) {
    productService.updateProduct(productDto);

    return getProducts(model, pageable);
  }

  @GetMapping("/products/old")
  public String getProducts(Model model,
                            @PageableDefault(size = 5, sort = {"price"}, direction = Sort.Direction.ASC) Pageable pageable) {
    final Page<ProductDto> allProducts = productService.getAllProductsPage(pageable);
    model.addAttribute("productList", allProducts);

    return "product/products";
  }

  @PreAuthorize("hasRole('ADMIN')")
  @GetMapping(HttpEndpoints.PRODUCTS_DELETE)
  public String deleteProduct(Model model, Pageable pageable, @PathVariable UUID productId) {
    productService.deleteProductByUUID(productId);

    return getProducts(model, pageable);
  }
}
