package lt.codeacademy.eshop;

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
