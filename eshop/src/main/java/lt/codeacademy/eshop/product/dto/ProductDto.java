package lt.codeacademy.eshop.product.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
public class ProductDto {
  private UUID productId;
  private String name;
  private double price;
  private int amount;
}
