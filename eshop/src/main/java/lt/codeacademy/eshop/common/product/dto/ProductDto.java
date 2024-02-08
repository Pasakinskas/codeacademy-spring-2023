package lt.codeacademy.eshop.common.product.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@Builder
public class ProductDto {
  private UUID productId;
  @NotBlank(message = "{productdto.name.notblank}")
  private String name;
  @Positive(message = "{productdto.positive}")
  private BigDecimal price;
  @Positive(message = "{productdto.positive}")
  @NotNull
  private int amount;
  @NotNull
  private List<Long> categoryIds;
}
