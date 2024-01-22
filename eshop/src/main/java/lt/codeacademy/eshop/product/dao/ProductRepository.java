package lt.codeacademy.eshop.product.dao;

import lt.codeacademy.eshop.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

  Optional<Product> findByProductId(UUID id);

  void deleteProductByProductId(UUID id);
}
