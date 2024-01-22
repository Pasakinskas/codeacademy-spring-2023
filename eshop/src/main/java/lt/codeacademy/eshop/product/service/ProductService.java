package lt.codeacademy.eshop.product.service;

import lt.codeacademy.eshop.mappers.ProductMapper;
import lt.codeacademy.eshop.product.Product;
import lt.codeacademy.eshop.product.dao.ProductDao;
import lt.codeacademy.eshop.product.dto.ProductDto;
import lt.codeacademy.eshop.product.exception.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ProductService {

  private ProductDao productDao;
  private ProductMapper mapper;

  @Autowired
  public ProductService(ProductDao productDao, ProductMapper mapper) {
    this.productDao = productDao;
    this.mapper = mapper;
  }

  public void saveProduct(ProductDto productDto) {
    var product = mapper.fromProductDto(productDto);
    productDao.save(product);
  }

  public void updateProduct(Product product) {
    productDao.update(product);
  }

  public Page<ProductDto> getAllProductsPage(Pageable pageable) {
    return productDao.getPage(pageable).map(product -> mapper.toProductDto(product));
  }

  public ProductDto getProductByUUID(UUID id) {
    return productDao.getProductByUUID(id)
      .map(mapper::toProductDto)
      .orElseThrow(ProductNotFoundException::new);
  }

  public void deleteProductByUUID(UUID id) {
    productDao.deleteProductByUUID(id);
  }
}
