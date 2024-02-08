package lt.codeacademy.eshop.common.product.dao;

import lt.codeacademy.eshop.jpa.entities.Product;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductDao {

  Product save(Product product);

  void update(Product product);

  List<Product> getAll();

  Page<Product> getPage(Pageable pageable);

  Optional<Product> getProductByUUID(UUID id);

  void deleteProductByUUID(UUID id);
}
