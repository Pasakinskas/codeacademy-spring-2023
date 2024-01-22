package lt.codeacademy.eshop.product.dao;

import lt.codeacademy.eshop.product.pojo.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@Primary
public class ProductJPADao implements ProductDao {

  ProductRepository repository;

  @Autowired
  public ProductJPADao(ProductRepository productRepository) {
    this.repository = productRepository;
  }

  @Override
  public void save(Product product) {
    product.setProductId(UUID.randomUUID());
    repository.save(product);
  }

  @Override
  public void update(Product product) {
    repository.save(product);
  }

  @Override
  public List<Product> getAll() {
    return repository.findAll();
  }

  @Override
  public Page<Product> getPage(Pageable pageable) {
    return repository.findAll(pageable);
  }

  @Override
  public Optional<Product> getProductByUUID(UUID id) {
    return repository.findByProductId(id);
  }

  @Override
  public void deleteProductByUUID(UUID id) {
    repository.deleteProductByProductId(id);
  }
}
