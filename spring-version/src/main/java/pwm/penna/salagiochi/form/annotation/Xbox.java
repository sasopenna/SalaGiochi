package pwm.penna.salagiochi.form.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import pwm.penna.salagiochi.form.validator.XboxValidator;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = XboxValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface Xbox {
    String message() default "{validator.invalid_device}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
