package lt.codeacademy.security.core.registration.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lt.codeacademy.core.PhoneNumber;
import lt.codeacademy.security.core.validation.RepeatPassword;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
@RepeatPassword
public class UserRegistrationDto {
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
  private String repeatPassword;
  @NotBlank
  private String zipCode;
  @NotBlank
  @PhoneNumber
  private String phoneNumber;
}
