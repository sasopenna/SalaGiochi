package pwm.penna.salagiochi.form.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import pwm.penna.salagiochi.form.dto.base.BaseForm;
import pwm.penna.salagiochi.model.cassiere.Cassiere;

import java.time.LocalTime;

public class AssegnazioneForm extends BaseForm<Integer> {

    private Integer prenotazione;

    @NotNull(message = "{validator.required}")
    private Cassiere cassiere;

    @NotNull(message = "{validator.required}")
    @DecimalMin(value = "0.0", message = "{validator.double_min}")
    private Double costo;

    @NotNull(message = "{validator.required}")
    private LocalTime orario;

    public Integer getPrenotazione() {
        return prenotazione;
    }

    public void setPrenotazione(Integer prenotazione) {
        this.prenotazione = prenotazione;
    }

    public Cassiere getCassiere() {
        return cassiere;
    }

    public void setCassiere(Cassiere cassiere) {
        this.cassiere = cassiere;
    }

    public Double getCosto() {
        return costo;
    }

    public void setCosto(Double costo) {
        this.costo = costo;
    }

    public LocalTime getOrario() {
        return orario;
    }

    public void setOrario(LocalTime orario) {
        this.orario = orario;
    }

    @Override
    public Integer getKey() {
        return getPrenotazione();
    }

    @Override
    public void setKey(Integer key) {
        setPrenotazione(key);
    }
}
