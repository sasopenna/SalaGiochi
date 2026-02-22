package pwm.penna.salagiochi.form.validator.ddg;

import org.springframework.stereotype.Component;
import pwm.penna.salagiochi.form.annotation.ddg.PlayStation;

import java.util.Set;

@Component
public class PlayStationValidator extends ModelloValidator<PlayStation> {
    public PlayStationValidator() {
        super(Set.of("1", "2", "3", "4", "5"));
    }
}
