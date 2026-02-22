package pwm.penna.salagiochi.form.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import pwm.penna.salagiochi.form.dto.base.BaseForm;
import pwm.penna.salagiochi.model.dispositivodigioco.DispositivoDiGioco;
import pwm.penna.salagiochi.model.tecnico.Tecnico;

public class RiparaForm extends BaseForm<Integer> {

    private Integer progressivo;

    @NotNull(message = "{validator.required}")
    private Tecnico tecnico;

    @NotNull(message = "{validator.required}")
    private DispositivoDiGioco dispositivoDiGioco;

    @NotNull(message = "{validator.required}")
    @DecimalMin(value = "0.0", message = "{validator.double_min}")
    private Double costoRiparazione;

    // getters & setters
    public Integer getProgressivo() {
        return progressivo;
    }

    public void setProgressivo(Integer progressivo) {
        this.progressivo = progressivo;
    }

    public Tecnico getTecnico() {
        return tecnico;
    }

    public void setTecnico(Tecnico tecnico) {
        this.tecnico = tecnico;
    }

    public DispositivoDiGioco getDispositivoDiGioco() {
        return dispositivoDiGioco;
    }

    public void setDispositivoDiGioco(DispositivoDiGioco dispositivoDiGioco) {
        this.dispositivoDiGioco = dispositivoDiGioco;
    }

    public Double getCostoRiparazione() {
        return costoRiparazione;
    }

    public void setCostoRiparazione(Double costoRiparazione) {
        this.costoRiparazione = costoRiparazione;
    }

    @Override
    public Integer getKey() {
        return getProgressivo();
    }

    @Override
    public void setKey(Integer key) {
        setProgressivo(key);
    }
}
