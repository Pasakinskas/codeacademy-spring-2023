package lt.codeacademy.eshop.product.service;

import lt.codeacademy.eshop.product.dao.ProductCategoryRepository;
import lt.codeacademy.eshop.product.dao.ProductDao;
import lt.codeacademy.eshop.product.dto.ProductDto;
import lt.codeacademy.eshop.product.mappers.ProductMapper;
import lt.codeacademy.eshop.product.pojo.Product;
import lt.codeacademy.eshop.product.pojo.ProductCategory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.math.BigDecimal;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

  @Mock
  private ProductCategoryRepository productCategoryRepository;

  @Mock
  private ProductDao productDao;

  @Mock
  private ProductMapper mapper;

  @InjectMocks
  private ProductService service;

  @Test
  public void saveProduct_savesAProductAndSetsCategory() {
    var productUUID = UUID.randomUUID();
    var categoryId = 123L;

    var productDto = new ProductDto(productUUID, "strawberry", BigDecimal.valueOf(1.95), 1, categoryId);
    var product = new Product();

    when(productCategoryRepository.getReferenceById(any())).thenReturn(new ProductCategory());
    when(mapper.fromDto(productDto)).thenReturn(product);

    service.saveProduct(productDto);

    verify(mapper).fromDto(eq(productDto));
    verify(productCategoryRepository).getReferenceById(eq(categoryId));
    verify(productDao).save(eq(product));
  }
}
