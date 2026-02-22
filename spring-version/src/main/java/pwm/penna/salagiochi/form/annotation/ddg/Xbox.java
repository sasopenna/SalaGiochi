package pwm.penna.salagiochi.form.annotation.ddg;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import pwm.penna.salagiochi.form.validator.ddg.XboxValidator;

import java.lang.annotation.*;

/**
 * Valida il modello di Xbox.
 * Equivalente Spring del vecchio XboxValidator Struts.
 * <p>
 * Valori accettati (case-insensitive): Series X, Series S, One X, One S, One, 360
 */
@Documented
@Constraint(validatedBy = XboxValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface Xbox {

    String message() default "Modello Xbox non valido. Valori accettati: Series X, Series S, One X, One S, One, 360";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
