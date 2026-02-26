package pwm.penna.salagiochi.form.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;
import pwm.penna.salagiochi.form.annotation.DispositivoDiGioco;
import pwm.penna.salagiochi.form.dto.base.BaseForm;

import java.time.LocalDate;

public class DispositivoDiGiocoForm extends BaseForm<Integer> {

    private Integer id;

    @NotBlank(message = "{validator.required}")
    @DispositivoDiGioco
    private String tipo;

    @NotNull(message = "{validator.required}")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataAcquisizione;

    @NotBlank(message = "{validator.required}")
    private String discriminator;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public LocalDate getDataAcquisizione() {
        return dataAcquisizione;
    }

    public void setDataAcquisizione(LocalDate dataAcquisizione) {
        this.dataAcquisizione = dataAcquisizione;
    }

    public String getDiscriminator() {
        return discriminator;
    }

    public void setDiscriminator(String discriminator) {
        this.discriminator = discriminator;
    }

    @Override
    public Integer getKey() {
        return getId();
    }

    @Override
    public void setKey(Integer key) {
        setId(key);
    }
}
