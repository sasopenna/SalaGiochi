package pwm.penna.salagiochi.form.annotation.ddg;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import pwm.penna.salagiochi.form.validator.ddg.PlayStationValidator;

import java.lang.annotation.*;

/**
 * Valida il modello di PlayStation.
 * Equivalente Spring del vecchio PlayStationValidator Struts.
 * <p>
 * Valori accettati (case-insensitive): 1, 2, 3, 4, 5
 */
@Documented
@Constraint(validatedBy = PlayStationValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface PlayStation {

    String message() default "Modello PlayStation non valido. Valori accettati: 1, 2, 3, 4, 5";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
