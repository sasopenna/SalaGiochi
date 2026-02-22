package pwm.penna.salagiochi.form.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import pwm.penna.salagiochi.form.annotation.OnlyLetters;

public class OnlyLettersValidator implements ConstraintValidator<OnlyLetters, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null || value.isBlank()) return true;
        return value.matches("[\\p{L} ]+");
    }
}
