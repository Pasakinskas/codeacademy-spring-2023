package lt.codeacademy.eshop.product;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Product {
  private String name;
  private double price;
  private int amount;
}
