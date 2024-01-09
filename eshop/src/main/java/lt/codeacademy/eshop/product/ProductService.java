package lt.codeacademy.eshop.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProductService {

  private ProductDao productDao;

  @Autowired
  public ProductService(@Qualifier("productJDBCDao") ProductDao productDao) {
    this.productDao = productDao;
  }

  public void saveProduct(Product product) {
    productDao.save(product);
  }

  public void updateProduct(Product product) {
    productDao.update(product);
  }

  public List<Product> getAllProducts() {
    return productDao.getAll();
  }

  public Product getProductByUUID(UUID id) {
    return productDao.getProductByUUID(id);
  }

  public void deleteProductByUUID(UUID id) {
    productDao.deleteProductByUUID(id);
  }
}