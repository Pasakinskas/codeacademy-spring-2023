package lt.codeacademy.eshop.jpa.repositories;

import lt.codeacademy.eshop.jpa.entities.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {
}
