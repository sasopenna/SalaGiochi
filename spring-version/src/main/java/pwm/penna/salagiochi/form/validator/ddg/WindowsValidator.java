package pwm.penna.salagiochi.form.validator.ddg;

import org.springframework.stereotype.Component;
import pwm.penna.salagiochi.form.annotation.ddg.Windows;

import java.util.Set;

@Component
public class WindowsValidator extends ModelloValidator<Windows> {
    public WindowsValidator() {
        super(Set.of("7", "8", "10", "11", "Vista", "XP"));
    }
}
