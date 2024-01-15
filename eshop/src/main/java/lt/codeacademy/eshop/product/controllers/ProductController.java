package lt.codeacademy.eshop.product.controllers;

import java.util.UUID;

import lombok.extern.log4j.Log4j2;
import lt.codeacademy.eshop.HttpEndpoints;
import lt.codeacademy.eshop.product.Product;
import lt.codeacademy.eshop.product.dto.ProductDto;
import lt.codeacademy.eshop.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@Log4j2
public class ProductController {

	private ProductService productService;

	@Autowired
	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	@GetMapping(HttpEndpoints.PRODUCTS_CREATE)
	public String getFormForCreate(Model model) {
    log.atInfo().log("-==== get product on create ====-");
		model.addAttribute("product", Product.builder().build());

		return "product/product";
	}

  @GetMapping(HttpEndpoints.PRODUCTS_UPDATE)
  public String getFormForUpdate(Model model, @PathVariable UUID productId) {
    log.atInfo().log("-==== get product on update ====-");
    model.addAttribute("product", productService.getProductByUUID(productId));

    return "product/product";
  }

	@PostMapping(HttpEndpoints.PRODUCTS_CREATE)
	public String createAProduct(Model model, Product product) {
		productService.saveProduct(product);
    model.addAttribute("message", "Product added successfully!");

    return "product/product";
	}

  @PostMapping(HttpEndpoints.PRODUCTS_UPDATE)
  public String updateProduct(Model model, Pageable pageable, Product product, @PathVariable UUID productId) {
    productService.updateProduct(product);

    return getProducts(model, pageable);
  }

  @GetMapping(HttpEndpoints.PRODUCTS)
  public String getProducts(Model model,
                            @PageableDefault(size = 15, sort = {"price"}, direction = Sort.Direction.ASC) Pageable pageable) {
    final Page<ProductDto> allProducts = productService.getAllProductsPage(pageable);
    model.addAttribute("productList", allProducts);

    return "product/products";
  }

  @GetMapping(HttpEndpoints.PRODUCTS_DELETE)
  public String deleteProduct(Model model, Pageable pageable, @PathVariable UUID productId) {
    productService.deleteProductByUUID(productId);

    return getProducts(model, pageable);
  }
}
