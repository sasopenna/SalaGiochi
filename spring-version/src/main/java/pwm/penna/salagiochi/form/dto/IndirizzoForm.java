package pwm.penna.salagiochi.form.dto;

import jakarta.validation.constraints.*;
import pwm.penna.salagiochi.form.annotation.OnlyLetters;

public class IndirizzoForm {

    @NotBlank(message = "{validator.required}")
    @OnlyLetters
    private String via;

    @NotNull(message = "{validator.required}")
    @Min(value = 0, message = "{validator.int_min}")
    @Max(value = 14500, message = "{validator.int_minmax}")
    private Integer numeroCivico;

    @NotBlank(message = "{validator.required}")
    @Size(max = 100, message = "{validator.maxlen}")
    @OnlyLetters
    private String citta;

    @NotNull(message = "{validator.required}")
    @Min(value = 0, message = "{validator.int_min}")
    @Max(value = 99999, message = "{validator.int_minmax}")
    private Integer cap;

    @Size(max = 100, message = "{validator.maxlen}")
    @OnlyLetters
    private String provincia;

    @Size(max = 100, message = "{validator.maxlen}")
    @OnlyLetters
    private String regione;

    public String getVia() {
        return via;
    }

    public void setVia(String via) {
        this.via = via;
    }

    public Integer getNumeroCivico() {
        return numeroCivico;
    }

    public void setNumeroCivico(Integer numeroCivico) {
        this.numeroCivico = numeroCivico;
    }

    public String getCitta() {
        return citta;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }

    public Integer getCap() {
        return cap;
    }

    public void setCap(Integer cap) {
        this.cap = cap;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getRegione() {
        return regione;
    }

    public void setRegione(String regione) {
        this.regione = regione;
    }
}
