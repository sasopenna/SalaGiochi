package pwm.penna.salagiochi.form.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import pwm.penna.salagiochi.form.validator.PlayStationValidator;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PlayStationValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface PlayStation {
    String message() default "{validator.invalid_device}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
