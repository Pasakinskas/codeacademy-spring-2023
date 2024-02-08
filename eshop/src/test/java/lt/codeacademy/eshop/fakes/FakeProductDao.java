package lt.codeacademy.eshop.fakes;

import lombok.Getter;
import lt.codeacademy.eshop.product.dao.ProductDao;
import lt.codeacademy.eshop.product.pojo.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class FakeProductDao implements ProductDao {

  private HashMap<UUID, Product> storage;

  public FakeProductDao() {
    this.storage = new HashMap<>();
  }

  @Override
  public Product save(Product product) {
    product.setId(storage.size() + 1);
    storage.put(product.getProductId(), product);

    return product;
  }

  @Override
  public void update(Product product) {
    storage.put(product.getProductId(), product);
  }

  @Override
  public List<Product> getAll() {
    return storage.values().stream().toList();
  }

  @Override
  public Page<Product> getPage(Pageable pageable) {
    return Page.empty();
  }

  @Override
  public Optional<Product> getProductByUUID(UUID id) {
    return Optional.of(storage.get(id));
  }

  @Override
  public void deleteProductByUUID(UUID id) {
      storage.remove(id);
  }
}
