package lt.codeacademy.eshop.product.dao;

import lt.codeacademy.eshop.product.pojo.Product;
import lt.codeacademy.eshop.product.pojo.ProductCategory;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class ProductJPADaoTest {

  @Test
  void save_FillsProductWithUUIDAndCallsRepository() {
    var repository = mock(ProductRepository.class);
    var productDao = new ProductJPADao(repository);
    var product = Product.builder()
      .productCategories(new HashSet<>())
      .name("banana")
      .price(BigDecimal.valueOf(0))
      .amount(1)
      .build();

    productDao.save(product);

    assertNotNull(product.getProductId());
    verify(repository).save(any(Product.class));
  }

  @Test
  void getByUUID_ReturnsAProductByUUID() {
    var repository = mock(ProductRepository.class);
    var productDao = new ProductJPADao(repository);
    var uuid = UUID.randomUUID();
    var product = Product.builder().productId(uuid).build();

    when(repository.findByProductId(uuid))
      .thenReturn(Optional.of(product));

    var actual = productDao.getProductByUUID(uuid);

    assertEquals(actual.get(), product);
  }
}
