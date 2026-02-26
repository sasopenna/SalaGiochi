package pwm.penna.salagiochi.form.validator;

import pwm.penna.salagiochi.form.annotation.CodiceFiscale;
import pwm.penna.salagiochi.form.validator.base.BaseRegexValidator;

public class CodiceFiscaleValidator extends BaseRegexValidator<CodiceFiscale> {
    public CodiceFiscaleValidator() {
        super("^[A-Z]{6}[0-9]{2}[A-EHLMPR-T]{1}[0-9]{2}[A-Z]{1}[0-9]{3}[A-Z]{1}$");
    }
}
