package pwm.penna.salagiochi.form.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import pwm.penna.salagiochi.model.salagiochi.SalaGiochi;

public class PostazioneIdForm {

    @NotNull(message = "{validator.required}")
    private SalaGiochi salaGiochi = new SalaGiochi();

    @NotNull(message = "{validator.required}")
    @Min(value = 0, message = "{validator.int_min}")
    private Integer stanza;

    @NotNull(message = "{validator.required}")
    @Min(value = 0, message = "{validator.int_min}")
    private Integer posto;

    // getters & setters
    public SalaGiochi getSalaGiochi() {
        return salaGiochi;
    }

    public void setSalaGiochi(SalaGiochi salaGiochi) {
        this.salaGiochi = salaGiochi;
    }

    public Integer getStanza() {
        return stanza;
    }

    public void setStanza(Integer stanza) {
        this.stanza = stanza;
    }

    public Integer getPosto() {
        return posto;
    }

    public void setPosto(Integer posto) {
        this.posto = posto;
    }
}
