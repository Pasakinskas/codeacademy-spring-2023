package lt.codeacademy.eshop.product;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class ProductDao {
  private List<Product> products = new ArrayList<>();

  public void save(Product product) {
    product.setUuid(UUID.randomUUID());
    products.add(product);
  }

  public List<Product> getAll() {
    return products;
  }
}
