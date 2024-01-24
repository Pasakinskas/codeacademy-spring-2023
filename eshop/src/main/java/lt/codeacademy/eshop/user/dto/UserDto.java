package lt.codeacademy.eshop.user.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class UserDto {
  @NotBlank
  private String name;
  @NotBlank
  private String surname;
  @NotBlank
  private String email;
  @NotBlank
  private String password;
  @NotBlank
  private String zipCode;
  @NotBlank
  private String phoneNumber;
}
