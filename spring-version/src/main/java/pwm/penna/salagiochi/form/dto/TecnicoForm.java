package pwm.penna.salagiochi.form.dto;

import jakarta.validation.constraints.NotBlank;
import pwm.penna.salagiochi.form.annotation.DispositivoDiGioco;

public class TecnicoForm extends DipendenteForm {

    @NotBlank(message = "{validator.required}")
    @DispositivoDiGioco
    private String specializzazione;

    public String getSpecializzazione() {
        return specializzazione;
    }

    public void setSpecializzazione(String specializzazione) {
        this.specializzazione = specializzazione;
    }
}
