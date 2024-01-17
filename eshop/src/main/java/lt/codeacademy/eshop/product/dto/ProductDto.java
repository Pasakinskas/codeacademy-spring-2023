package lt.codeacademy.eshop.product.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
@Builder
public class ProductDto {
  private UUID productId;
  private String name;
  private double price;
  @Positive
  @NotNull
  private int amount;
}
