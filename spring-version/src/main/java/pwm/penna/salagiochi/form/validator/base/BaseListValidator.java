package pwm.penna.salagiochi.form.validator.base;

import java.lang.annotation.Annotation;
import java.util.Set;

public abstract class BaseListValidator<A extends Annotation> extends BaseValidator<A> {
    private final Set<String> lista;

    public BaseListValidator(Set<String> lista) {
        this.lista = lista;
    }

    public Set<String> getLista() {
        return lista;
    }

    @Override
    public boolean validation(String value) {
        return lista.contains(value);
    }
}
