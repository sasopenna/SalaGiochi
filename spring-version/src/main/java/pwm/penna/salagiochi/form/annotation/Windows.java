package pwm.penna.salagiochi.form.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import pwm.penna.salagiochi.form.validator.WindowsValidator;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = WindowsValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface Windows {
    String message() default "{validator.invalid_device}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
