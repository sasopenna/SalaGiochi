package pwm.penna.salagiochi.form.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import pwm.penna.salagiochi.form.dto.base.BaseForm;

import java.time.LocalTime;

public class DipendenteForm extends BaseForm<Integer> {

    private Integer idDipendente;

    @Valid
    private ProfiloForm profilo = new ProfiloForm();

    @NotNull(message = "{validator.required}")
    @DecimalMin(value = "0.0", message = "{validator.double_min}")
    private Double salario;

    @NotNull(message = "{validator.required}")
    private LocalTime inizioTurno;

    @NotNull(message = "{validator.required}")
    private LocalTime fineTurno;

    public Integer getIdDipendente() {
        return idDipendente;
    }

    public void setIdDipendente(Integer idDipendente) {
        this.idDipendente = idDipendente;
    }

    public ProfiloForm getProfilo() {
        return profilo;
    }

    public void setProfilo(ProfiloForm profilo) {
        this.profilo = profilo;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public LocalTime getInizioTurno() {
        return inizioTurno;
    }

    public void setInizioTurno(LocalTime inizioTurno) {
        this.inizioTurno = inizioTurno;
    }

    public LocalTime getFineTurno() {
        return fineTurno;
    }

    public void setFineTurno(LocalTime fineTurno) {
        this.fineTurno = fineTurno;
    }

    @Override
    public Integer getKey() {
        return getIdDipendente();
    }

    @Override
    public void setKey(Integer key) {
        setIdDipendente(key);
    }
}
