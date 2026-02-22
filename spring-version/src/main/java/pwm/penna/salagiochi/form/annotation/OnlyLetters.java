package pwm.penna.salagiochi.form.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import pwm.penna.salagiochi.form.validator.OnlyLettersValidator;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = OnlyLettersValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface OnlyLetters {
    String message() default "{validator.onlyletters}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
