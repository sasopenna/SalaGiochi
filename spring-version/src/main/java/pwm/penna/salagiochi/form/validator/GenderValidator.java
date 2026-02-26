package pwm.penna.salagiochi.form.validator;

import pwm.penna.salagiochi.form.annotation.Gender;
import pwm.penna.salagiochi.form.validator.base.BaseListValidator;

import java.util.Set;

public class GenderValidator extends BaseListValidator<Gender> {
    public GenderValidator() {
        super(Set.of("Uomo", "Donna"));
    }
}
