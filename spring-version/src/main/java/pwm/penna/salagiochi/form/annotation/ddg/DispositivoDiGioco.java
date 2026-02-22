package pwm.penna.salagiochi.form.annotation.ddg;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import pwm.penna.salagiochi.form.validator.ddg.DispositivoDiGiocoValidator;

import java.lang.annotation.*;

/**
 * Valida che il tipo di dispositivo di gioco sia uno tra: XBOX, PLAYSTATION, WINDOWS.
 */
@Documented
@Constraint(validatedBy = DispositivoDiGiocoValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface DispositivoDiGioco {

    String message() default "Dispositivo di gioco non valido. Valori accettati: XBOX, PLAYSTATION, WINDOWS";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
