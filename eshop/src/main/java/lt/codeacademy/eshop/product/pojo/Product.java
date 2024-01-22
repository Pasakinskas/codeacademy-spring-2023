package lt.codeacademy.eshop.product.pojo;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Product {

  @Id()
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  private UUID productId;
  private String name;
  private double price;
  private int amount;
}
