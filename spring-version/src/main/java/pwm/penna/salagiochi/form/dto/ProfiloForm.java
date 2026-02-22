package pwm.penna.salagiochi.form.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;
import pwm.penna.salagiochi.form.annotation.CodiceFiscale;
import pwm.penna.salagiochi.form.annotation.Gender;
import pwm.penna.salagiochi.form.annotation.OnlyLetters;

import java.time.LocalDate;

public class ProfiloForm {

    @NotBlank(message = "{validator.required}")
    @Size(max = 50, message = "{validator.maxlen}")
    @OnlyLetters
    private String nome;

    @NotBlank(message = "{validator.required}")
    @Size(max = 50, message = "{validator.maxlen}")
    @OnlyLetters
    private String cognome;

    @NotBlank(message = "{validator.required}")
    @Gender
    private String sesso;

    @NotBlank(message = "{validator.required}")
    @CodiceFiscale
    private String codiceFiscale;

    @NotNull(message = "{validator.required}")
    @Min(value = 3000000000L, message = "{validator.telefono}")
    @Max(value = 3999999999L, message = "{validator.telefono}")
    private Long telefono;

    @NotBlank(message = "{validator.required}")
    @Email(message = "{validator.email}")
    private String email;

    @NotNull(message = "{validator.required}")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataDiNascita;

    @Valid
    private IndirizzoForm indirizzo = new IndirizzoForm();

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getSesso() {
        return sesso;
    }

    public void setSesso(String sesso) {
        this.sesso = sesso;
    }

    public String getCodiceFiscale() {
        return codiceFiscale;
    }

    public void setCodiceFiscale(String codiceFiscale) {
        this.codiceFiscale = codiceFiscale;
    }

    public Long getTelefono() {
        return telefono;
    }

    public void setTelefono(Long telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDataDiNascita() {
        return dataDiNascita;
    }

    public void setDataDiNascita(LocalDate dataDiNascita) {
        this.dataDiNascita = dataDiNascita;
    }

    public IndirizzoForm getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(IndirizzoForm indirizzo) {
        this.indirizzo = indirizzo;
    }
}
