package lt.codeacademy.eshop.product;

import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class ProductMockDao implements ProductDao {
  private Map<UUID, Product> products = new HashMap<>();

  public void save(Product product) {
    final UUID uuid = UUID.randomUUID();
    product.setProductId(uuid);
    products.put(uuid, product);
  }

  public void update(Product product) {
    products.put(product.getProductId(), product);
  }

  public List<Product> getAll() {
    return new ArrayList<>(products.values());
  }

  public Product getProductByUUID(UUID id) {
    return products.get(id);
  }

  public void deleteProductByUUID(UUID id) {
    products.remove(id);
  }
}
