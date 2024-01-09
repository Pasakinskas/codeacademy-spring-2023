package lt.codeacademy.eshop.product;

import java.util.List;
import java.util.UUID;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.log4j.Log4j2;
import lt.codeacademy.eshop.HttpEndpoints;
import org.springframework.beans.factory.annotation.Autowired;
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
	public String createAProduct(Product product) {
		productService.saveProduct(product);
		System.out.println("currently in the database");
		productService.getAllProducts().forEach(System.out::println);

		return "product/products";
	}

  @PostMapping(HttpEndpoints.PRODUCTS_UPDATE)
  public String updateProduct(Model model, Product product, @PathVariable UUID productId) {
    productService.updateProduct(product);

    return getProducts(model);
  }

  @GetMapping(HttpEndpoints.PRODUCTS)
  public String getProducts(Model model) {
    final List<Product> allProducts = productService.getAllProducts();
    model.addAttribute("productList", allProducts);

    return "product/products";
  }

  @GetMapping(HttpEndpoints.PRODUCTS_DELETE)
  public String deleteProduct(Model model, @PathVariable UUID productId) {
    productService.deleteProductByUUID(productId);

    return getProducts(model);
  }
}
