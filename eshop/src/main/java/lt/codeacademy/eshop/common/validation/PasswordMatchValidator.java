package lt.codeacademy.eshop.common.validation;

import java.util.Objects;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lt.codeacademy.eshop.common.user.dto.UserDto;

public class PasswordMatchValidator implements ConstraintValidator<RepeatPassword, UserDto> {

  @Override
  public boolean isValid(UserDto userDto, ConstraintValidatorContext context) {
    return Objects.nonNull(userDto.getPassword()) && userDto.getPassword().equals(userDto.getRepeatPassword());
  }
}
