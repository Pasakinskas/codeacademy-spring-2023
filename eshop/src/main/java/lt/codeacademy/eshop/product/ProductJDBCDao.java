package lt.codeacademy.eshop.product;

import java.util.List;
import java.util.UUID;

import lombok.RequiredArgsConstructor;
import lt.codeacademy.eshop.product.mapper.ProductJDBCRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ProductJDBCDao implements ProductDao {

  private final JdbcTemplate jdbcTemplate;
  private final ProductJDBCRowMapper productJDBCRowMapper;

  @Override
  public void save(Product product) {
    product.setProductId(UUID.randomUUID());
    jdbcTemplate.update("INSERT INTO PRODUCT(PRODUCT_ID, NAME, PRICE, AMOUNT) VALUES (?, ?, ?, ?)",
      product.getProductId(), product.getName(), product.getPrice(), product.getAmount());
  }

  @Override
  public void update(Product product) {
    jdbcTemplate.update("UPDATE PRODUCT SET name = ?, price = ?, amount = ? WHERE product_id = ?",
      product.getName(), product.getPrice(), product.getAmount(), product.getProductId());
  }

  @Override
  public List<Product> getAll() {
    return jdbcTemplate.query(
      "SELECT * FROM PRODUCT", productJDBCRowMapper);
  }

  @Override
  public Product getProductByUUID(UUID id) {
    final List<Product> products = jdbcTemplate.query(
      String.format("SELECT * FROM PRODUCT WHERE product_id = '%s'", id.toString()), productJDBCRowMapper);

    return products.get(0);
  }

  @Override
  public void deleteProductByUUID(UUID id) {
    jdbcTemplate.execute(String.format("DELETE FROM PRODUCT WHERE PRODUCT_ID = '%s'", id.toString()));
  }
}
