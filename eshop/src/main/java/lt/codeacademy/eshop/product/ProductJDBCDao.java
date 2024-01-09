package lt.codeacademy.eshop.product;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Primary
@Repository
public class ProductJDBCDao implements ProductDao {

  @Override
  public void save(Product product) {

  }

  @Override
  public void update(Product product) {

  }

  @Override
  public List<Product> getAll() {
    return Collections.emptyList();
  }

  @Override
  public Product getProductByUUID(UUID id) {
    return null;
  }

  @Override
  public void deleteProductByUUID(UUID id) {

  }
}
