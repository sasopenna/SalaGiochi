package pwm.penna.salagiochi.form.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import pwm.penna.salagiochi.model.salagiochi.SalaGiochi;

import java.util.Set;

public class DirigenteForm extends DipendenteForm {

    @NotNull(message = "{validator.required}")
    @Min(value = 0, message = "{validator.int_min}")
    private Integer periodo;

    @NotNull(message = "{validator.required}")
    @Min(value = 0, message = "{validator.int_min}")
    private Integer esperienza;

    private Set<SalaGiochi> saleGiochi;

    public Integer getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Integer periodo) {
        this.periodo = periodo;
    }

    public Integer getEsperienza() {
        return esperienza;
    }

    public void setEsperienza(Integer esperienza) {
        this.esperienza = esperienza;
    }

    public Set<SalaGiochi> getSaleGiochi() {
        return saleGiochi;
    }

    public void setSaleGiochi(Set<SalaGiochi> saleGiochi) {
        this.saleGiochi = saleGiochi;
    }
}
