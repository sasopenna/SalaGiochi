package pwm.penna.salagiochi.form.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import pwm.penna.salagiochi.form.dto.base.BaseForm;

public class SocioForm extends BaseForm<Integer> {

    private Integer numeroCliente;

    @Valid
    private ProfiloForm profilo = new ProfiloForm();

    @NotNull(message = "{validator.required}")
    @Min(value = 0, message = "{validator.int_min}")
    private Integer punteggio;

    // getters & setters
    public Integer getNumeroCliente() {
        return numeroCliente;
    }

    public void setNumeroCliente(Integer numeroCliente) {
        this.numeroCliente = numeroCliente;
    }

    public ProfiloForm getProfilo() {
        return profilo;
    }

    public void setProfilo(ProfiloForm profilo) {
        this.profilo = profilo;
    }

    public Integer getPunteggio() {
        return punteggio;
    }

    public void setPunteggio(Integer punteggio) {
        this.punteggio = punteggio;
    }

    @Override
    public Integer getKey() {
        return getNumeroCliente();
    }

    @Override
    public void setKey(Integer key) {
        setNumeroCliente(key);
    }
}
