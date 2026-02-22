package pwm.penna.salagiochi.form.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import pwm.penna.salagiochi.model.salagiochi.SalaGiochi;

public class CassiereForm extends DipendenteForm {

    @NotNull(message = "{validator.required}")
    private SalaGiochi salaGiochi;

    @NotNull(message = "{validator.required}")
    @Min(value = 0, message = "{validator.int_min}")
    private Integer sportello;

    public SalaGiochi getSalaGiochi() {
        return salaGiochi;
    }

    public void setSalaGiochi(SalaGiochi salaGiochi) {
        this.salaGiochi = salaGiochi;
    }

    public Integer getSportello() {
        return sportello;
    }

    public void setSportello(Integer sportello) {
        this.sportello = sportello;
    }
}
