package lt.codeacademy.eshop.product.dao;

import lt.codeacademy.eshop.product.Product;

import java.util.List;
import java.util.UUID;

public interface ProductDao {

  void save(Product product);

  void update(Product product);

  List<Product> getAll();

  Product getProductByUUID(UUID id);

  void deleteProductByUUID(UUID id);
}
