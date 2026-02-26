package pwm.penna.salagiochi.form.validator;

import pwm.penna.salagiochi.form.annotation.ValidPassword;
import pwm.penna.salagiochi.form.validator.base.BaseRegexValidator;

public class PasswordValidator extends BaseRegexValidator<ValidPassword> {
    public PasswordValidator() {
        super("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{8,}$");
    }
}
