package lt.codeacademy.eshop.validation;

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
      return value.startsWith("+370") && value.length() == 12;
    } else {
      return value.startsWith("86") && value.length() == 9;
    }
  }
}
