package lt.codeacademy.eshop.product.dao;

import lt.codeacademy.eshop.product.pojo.Product;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductDao {

  void save(Product product);

  void update(Product product);

  List<Product> getAll();

  Page<Product> getPage(Pageable pageable);

  Optional<Product> getProductByUUID(UUID id);

  void deleteProductByUUID(UUID id);
}
