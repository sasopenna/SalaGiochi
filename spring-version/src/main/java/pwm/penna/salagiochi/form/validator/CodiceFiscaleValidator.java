package pwm.penna.salagiochi.form.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import pwm.penna.salagiochi.form.annotation.CodiceFiscale;

public class CodiceFiscaleValidator implements ConstraintValidator<CodiceFiscale, String> {
    private static final String CF_REGEX =
            "^[A-Z]{6}[0-9]{2}[A-EHLMPR-T]{1}[0-9]{2}[A-Z]{1}[0-9]{3}[A-Z]{1}$";

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null || value.isBlank()) return true;
        return value.toUpperCase().matches(CF_REGEX);
    }
}
