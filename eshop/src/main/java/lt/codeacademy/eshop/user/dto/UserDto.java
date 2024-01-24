package lt.codeacademy.eshop.user.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import lt.codeacademy.eshop.validation.PhoneNumber;

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
  @Email
  private String email;
  @NotBlank
  private String password;
  @NotBlank
  private String zipCode;
  @NotBlank
  @PhoneNumber
  private String phoneNumber;
}
