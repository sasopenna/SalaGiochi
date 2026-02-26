package pwm.penna.salagiochi.form.validator;

import org.springframework.stereotype.Component;
import pwm.penna.salagiochi.form.annotation.Windows;
import pwm.penna.salagiochi.form.validator.base.BaseListValidator;

import java.util.Set;

@Component
public class WindowsValidator extends BaseListValidator<Windows> {
    public WindowsValidator() {
        super(Set.of("7", "8", "10", "11", "Vista", "XP"));
    }
}
