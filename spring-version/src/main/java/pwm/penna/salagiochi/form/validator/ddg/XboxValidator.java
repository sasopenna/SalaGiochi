package pwm.penna.salagiochi.form.validator.ddg;

import org.springframework.stereotype.Component;
import pwm.penna.salagiochi.form.annotation.ddg.Xbox;

import java.util.Set;

@Component
public class XboxValidator extends ModelloValidator<Xbox> {
    public XboxValidator() {
        super(Set.of("Series X", "Series S", "One X", "One S", "One", "360"));
    }
}
