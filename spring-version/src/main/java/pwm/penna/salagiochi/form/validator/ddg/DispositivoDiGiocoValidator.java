package pwm.penna.salagiochi.form.validator.ddg;

import pwm.penna.salagiochi.form.annotation.ddg.DispositivoDiGioco;

import java.util.Set;

public class DispositivoDiGiocoValidator extends ModelloValidator<DispositivoDiGioco> {
    public DispositivoDiGiocoValidator() {
        super(Set.of("PlayStation", "Xbox", "PC"));
    }
}
