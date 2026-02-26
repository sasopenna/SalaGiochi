package pwm.penna.salagiochi.form.validator.base;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.lang.annotation.Annotation;

abstract class BaseValidator<A extends Annotation> implements ConstraintValidator<A, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        if (value == null || value.isBlank()) return true;
        return validation(value.trim());
    }

    abstract boolean validation(String value);
}
