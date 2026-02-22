package pwm.penna.salagiochi.form.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import pwm.penna.salagiochi.form.validator.CodiceFiscaleValidator;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = CodiceFiscaleValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CodiceFiscale {
    String message() default "{validator.cf}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
