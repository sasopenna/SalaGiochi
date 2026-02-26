package pwm.penna.salagiochi.form.validator;

import org.springframework.stereotype.Component;
import pwm.penna.salagiochi.form.annotation.Xbox;
import pwm.penna.salagiochi.form.validator.base.BaseListValidator;

import java.util.Set;

@Component
public class XboxValidator extends BaseListValidator<Xbox> {
    public XboxValidator() {
        super(Set.of("Series X", "Series S", "One X", "One S", "One", "360"));
    }
}
