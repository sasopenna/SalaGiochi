package pwm.penna.salagiochi.form.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import pwm.penna.salagiochi.form.annotation.Gender;

public class GenderValidator implements ConstraintValidator<Gender, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null || value.isBlank()) return true;
        return value.equals("Uomo") || value.equals("Donna");
    }
}
