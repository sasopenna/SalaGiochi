package pwm.penna.salagiochi.form.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import pwm.penna.salagiochi.form.validator.DispositivoDiGiocoValidator;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = DispositivoDiGiocoValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface DispositivoDiGioco {
    String message() default "{validator.invalid_device}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
