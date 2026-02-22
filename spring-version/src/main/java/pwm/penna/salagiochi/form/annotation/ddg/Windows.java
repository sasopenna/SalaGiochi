package pwm.penna.salagiochi.form.annotation.ddg;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import pwm.penna.salagiochi.form.validator.ddg.WindowsValidator;

import java.lang.annotation.*;

/**
 * Valida la versione di Windows.
 * Equivalente Spring del vecchio WindowsValidator Struts.
 * <p>
 * Valori accettati (case-insensitive): XP, Vista, 7, 8, 10, 11
 */
@Documented
@Constraint(validatedBy = WindowsValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface Windows {

    String message() default "Versione Windows non valida. Valori accettati: XP, Vista, 7, 8, 10, 11";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
