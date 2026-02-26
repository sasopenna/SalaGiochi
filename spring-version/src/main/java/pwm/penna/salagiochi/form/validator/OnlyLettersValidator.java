package pwm.penna.salagiochi.form.validator;

import pwm.penna.salagiochi.form.annotation.OnlyLetters;
import pwm.penna.salagiochi.form.validator.base.BaseRegexValidator;

public class OnlyLettersValidator extends BaseRegexValidator<OnlyLetters> {
    public OnlyLettersValidator() {
        super("[\\p{L} ]+");
    }
}
