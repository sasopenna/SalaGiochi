package pwm.penna.salagiochi.form.validator.ddg;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.lang.annotation.Annotation;
import java.util.Set;

abstract class ModelloValidator<A extends Annotation> implements ConstraintValidator<A, String> {
    private final Set<String> lista;

    public ModelloValidator(Set<String> lista) {
        this.lista = lista;
    }

    public Set<String> getLista() {
        return lista;
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        if (value == null || value.isBlank()) return true;
        return lista.contains(value.trim());
    }
}
