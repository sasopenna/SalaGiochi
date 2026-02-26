package pwm.penna.salagiochi.form.validator.base;

import java.lang.annotation.Annotation;

public abstract class BaseRegexValidator<A extends Annotation> extends BaseValidator<A> {
    private final String regex;

    public BaseRegexValidator(String regex) {
        this.regex = regex;
    }

    public String getRegex() {
        return regex;
    }

    @Override
    public boolean validation(String value) {
        return value.matches(regex);
    }
}
