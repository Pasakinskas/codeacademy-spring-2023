package lt.codeacademy.eshop.security.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lt.codeacademy.eshop.security.registration.dto.UserRegistrationDto;

import java.util.Objects;

public class PasswordMatchValidator implements ConstraintValidator<RepeatPassword, UserRegistrationDto> {

  @Override
  public boolean isValid(UserRegistrationDto userDto, ConstraintValidatorContext context) {
    return Objects.nonNull(userDto.getPassword()) && userDto.getPassword().equals(userDto.getRepeatPassword());
  }
}
