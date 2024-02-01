package lt.codeacademy.eshop.product.service;

import lt.codeacademy.eshop.fakes.FakeProductDao;
import lt.codeacademy.eshop.product.dao.ProductCategoryRepository;
import lt.codeacademy.eshop.product.dto.ProductDto;
import lt.codeacademy.eshop.product.mappers.ProductMapper;
import lt.codeacademy.eshop.product.pojo.ProductCategory;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;


import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ProductServiceTest {

  @Test
  public void saveProduct_savesAProductAndSetsCategory() {
    var productUUID = UUID.randomUUID();
    var categoryId = 123L;

    var productDto = new ProductDto(productUUID, "strawberry", BigDecimal.valueOf(1.95), 1, categoryId);
    var productCategory = new ProductCategory(categoryId, "food");

    var productCategoryRepository = mock(ProductCategoryRepository.class);
    when(productCategoryRepository.getReferenceById(categoryId)).thenReturn(productCategory);

    var fakeProductDao = new FakeProductDao();

    var productsService = new ProductService(fakeProductDao, productCategoryRepository, new ProductMapper());

    productsService.saveProduct(productDto);

    var savedProduct = fakeProductDao.getProductByUUID(productUUID)
      .orElseThrow(() -> new RuntimeException("Product was not saved"));

    var categoryOnProduct = savedProduct.getProductCategories().stream().findFirst()
      .orElseThrow(() -> new RuntimeException("Product has no category"));

    assertEquals(categoryOnProduct.getId(), categoryId);
    assertEquals(categoryOnProduct.getName(), productCategory.getName());

    assertTrue(savedProduct.getId() > 0);
  }
}
