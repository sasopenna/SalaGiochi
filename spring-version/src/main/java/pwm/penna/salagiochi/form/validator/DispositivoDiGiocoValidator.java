package pwm.penna.salagiochi.form.validator;

import pwm.penna.salagiochi.form.annotation.DispositivoDiGioco;
import pwm.penna.salagiochi.form.validator.base.BaseListValidator;

import java.util.Set;

public class DispositivoDiGiocoValidator extends BaseListValidator<DispositivoDiGioco> {
    public DispositivoDiGiocoValidator() {
        super(Set.of("PlayStation", "Xbox", "PC"));
    }
}
