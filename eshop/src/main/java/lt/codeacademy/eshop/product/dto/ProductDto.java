package lt.codeacademy.eshop.product.dto;

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
  @Positive(message = "{productdto.amount.positive}")
  @NotNull
  private int amount;
}
