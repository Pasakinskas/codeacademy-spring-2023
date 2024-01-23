package lt.codeacademy.eshop.product.dao;

import lt.codeacademy.eshop.product.pojo.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {
}
