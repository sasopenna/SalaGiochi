package pwm.penna.salagiochi.form.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class ClienteForm {

    @NotNull(message = "{validator.required}")
    @Min(value = 0, message = "{validator.int_min}")
    private Integer numeroCliente;
}
