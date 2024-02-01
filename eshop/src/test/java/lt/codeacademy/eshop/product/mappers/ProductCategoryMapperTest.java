package lt.codeacademy.eshop.product.mappers;

import lt.codeacademy.eshop.product.pojo.ProductCategory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductCategoryMapperTest {

  @Test
  public void toDTO_whenGivenValidProduct_mapsToDto() {
    var categoryMapper = new ProductCategoryMapper();

    var productCategory = new ProductCategory(123L, "food");
    var dto = categoryMapper.toDto(productCategory);

    assertEquals(productCategory.getName(), dto.getName());
    assertEquals(productCategory.getId(), dto.getId());
  }
}
