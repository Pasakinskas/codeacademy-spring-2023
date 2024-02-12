package lt.codeacademy.eshop.common.validation;

import java.util.Objects;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PhoneNumberValidator implements ConstraintValidator<PhoneNumber, String> {

  private PhoneNumberType type;

  @Override
  public void initialize(PhoneNumber constraintAnnotation) {
    this.type = constraintAnnotation.numberType();
  }

  @Override
  public boolean isValid(String value, ConstraintValidatorContext context) {
    if (type.equals(PhoneNumberType.GLOBAL)) {
      return isValidPrefixGlobal(value);
    } else {
      return isValidPrefixLocal(value);
    }
  }

  private boolean isValidPrefixGlobal(final String phoneNumber) {
    return Objects.nonNull(phoneNumber) && phoneNumber.startsWith("+370") && phoneNumber.length() == 12;
  }

  private boolean isValidPrefixLocal(final String phoneNumber) {
    return Objects.nonNull(phoneNumber) && phoneNumber.startsWith("86") && phoneNumber.length() == 9;
  }
}
