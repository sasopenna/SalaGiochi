package pwm.penna.salagiochi.form.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import pwm.penna.salagiochi.form.annotation.OnlyLetters;
import pwm.penna.salagiochi.form.dto.base.BaseForm;

import java.time.LocalTime;

public class SalaGiochiForm extends BaseForm<Integer> {

    private Integer codice;

    @NotBlank(message = "{validator.required}")
    @Size(max = 50, message = "{validator.maxlen}")
    @OnlyLetters
    private String nome;

    @NotNull(message = "{validator.required}")
    @Min(value = 0, message = "{validator.int_min}")
    private Integer capienza;

    @NotNull(message = "{validator.required}")
    private LocalTime orarioApertura;

    @NotNull(message = "{validator.required}")
    private LocalTime orarioChiusura;

    @Valid
    private IndirizzoForm indirizzo = new IndirizzoForm();

    public Integer getCodice() {
        return codice;
    }

    public void setCodice(Integer codice) {
        this.codice = codice;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getCapienza() {
        return capienza;
    }

    public void setCapienza(Integer capienza) {
        this.capienza = capienza;
    }

    public LocalTime getOrarioApertura() {
        return orarioApertura;
    }

    public void setOrarioApertura(LocalTime orarioApertura) {
        this.orarioApertura = orarioApertura;
    }

    public LocalTime getOrarioChiusura() {
        return orarioChiusura;
    }

    public void setOrarioChiusura(LocalTime orarioChiusura) {
        this.orarioChiusura = orarioChiusura;
    }

    public IndirizzoForm getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(IndirizzoForm indirizzo) {
        this.indirizzo = indirizzo;
    }

    @Override
    public Integer getKey() {
        return getCodice();
    }

    @Override
    public void setKey(Integer key) {
        setCodice(key);
    }
}
