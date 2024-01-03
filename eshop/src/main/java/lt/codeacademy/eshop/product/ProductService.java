package lt.codeacademy.eshop.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

  private ProductDao productDao;

  @Autowired
  public ProductService(ProductDao productDao) {
    this.productDao = productDao;
  }

  public void saveProduct(Product product) {
    productDao.save(product);
  }

  public List<Product> getAllProducts() {
    return productDao.getAll();
  }
}
