package lt.codeacademy.eshop.security.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Constraint(validatedBy = PasswordMatchValidator.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface RepeatPassword {

  String message() default "Passwords must match";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}
