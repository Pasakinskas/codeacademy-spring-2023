package lt.codeacademy.eshop.product.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import lt.codeacademy.eshop.product.Product;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class ProductJDBCRowMapper implements RowMapper<Product> {

    @Override
    public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
      return Product.builder()
        .productId(UUID.fromString(rs.getString("product_id")))
        .name(rs.getString("name"))
        .price(rs.getDouble("price"))
        .amount(rs.getInt("amount"))
        .build();
    }
}
