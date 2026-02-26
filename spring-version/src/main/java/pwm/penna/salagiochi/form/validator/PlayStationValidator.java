package pwm.penna.salagiochi.form.validator;

import org.springframework.stereotype.Component;
import pwm.penna.salagiochi.form.annotation.PlayStation;
import pwm.penna.salagiochi.form.validator.base.BaseListValidator;

import java.util.Set;

@Component
public class PlayStationValidator extends BaseListValidator<PlayStation> {
    public PlayStationValidator() {
        super(Set.of("1", "2", "3", "4", "5"));
    }
}
