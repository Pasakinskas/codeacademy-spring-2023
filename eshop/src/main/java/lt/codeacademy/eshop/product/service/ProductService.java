package lt.codeacademy.eshop.product.service;

import lombok.RequiredArgsConstructor;
import lt.codeacademy.eshop.product.mappers.ProductMapper;
import lt.codeacademy.eshop.product.dao.ProductCategoryRepository;
import lt.codeacademy.eshop.product.dao.ProductDao;
import lt.codeacademy.eshop.product.dto.ProductDto;
import lt.codeacademy.eshop.product.exception.ProductNotFoundException;
import lt.codeacademy.eshop.product.pojo.Product;
import lt.codeacademy.eshop.product.pojo.ProductCategory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductService {

  private final ProductDao productDao;
  private final ProductCategoryRepository productCategoryRepository;
  private final ProductMapper mapper;

  @Transactional
  public void saveProduct(ProductDto productDto) {
    final Product product = mapper.fromDto(productDto);
    final ProductCategory productCategory = productCategoryRepository.getReferenceById(productDto.getCategoryIds().get(0));

    product.getProductCategories().add(productCategory);

    productDao.save(product);
  }

  @Transactional
  public ProductDto save(ProductDto productDto) {
    final Product product = mapper.fromDto(productDto);
    final ProductCategory productCategory = productCategoryRepository.getReferenceById(productDto.getCategoryIds().get(0));

    product.getProductCategories().add(productCategory);

    return mapper.toDto(productDao.save(product));
  }

  public void updateProduct(ProductDto productDto) {
    productDao.update(mapper.fromDto(productDto));
  }

  public Page<ProductDto> getAllProductsPage(Pageable pageable) {
    return productDao.getPage(pageable).map(product -> mapper.toDto(product));
  }

  public ProductDto getProductByUUID(UUID id) {
    return productDao.getProductByUUID(id)
      .map(mapper::toDto)
      .orElseThrow(() -> new ProductNotFoundException(id));
  }

  @Transactional
  public void deleteProductByUUID(UUID id) {
    productDao.deleteProductByUUID(id);
  }
}
