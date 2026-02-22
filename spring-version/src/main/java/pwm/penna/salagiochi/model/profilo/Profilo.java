package pwm.penna.salagiochi.model.profilo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import jakarta.persistence.*;
import pwm.penna.salagiochi.model.account.Account;
import pwm.penna.salagiochi.model.dipendente.Dipendente;
import pwm.penna.salagiochi.model.salagiochi.Indirizzo;
import pwm.penna.salagiochi.model.socio.Socio;

import java.time.LocalDate;

@Entity
@Table(name = "profilo")
public class Profilo {

    @Id
    @Column(name = "Email", length = 100)
    private String email;

    @JsonIgnore
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Account account;

    @Column(name = "Nome", length = 100, nullable = false)
    private String nome;

    @Column(name = "Cognome", length = 100, nullable = false)
    private String cognome;

    @Column(name = "Sesso", length = 10, nullable = false)
    private String sesso;

    @Column(name = "DataDiNascita", nullable = false)
    private LocalDate dataDiNascita;

    @Column(name = "CodiceFiscale", length = 16, nullable = false)
    private String codiceFiscale;

    @Column(name = "Telefono", nullable = false)
    private long telefono;

    @JsonUnwrapped // Retrocompatibilità
    @Embedded
    private Indirizzo indirizzo;

    @JsonIgnore
    @OneToOne(mappedBy = "profilo", fetch = FetchType.EAGER)
    private Socio socio;

    @JsonIgnore
    @OneToOne(mappedBy = "profilo", fetch = FetchType.EAGER)
    private Dipendente dipendente;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

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

    public LocalDate getDataDiNascita() {
        return dataDiNascita;
    }

    public void setDataDiNascita(LocalDate dataDiNascita) {
        this.dataDiNascita = dataDiNascita;
    }

    public String getCodiceFiscale() {
        return codiceFiscale;
    }

    public void setCodiceFiscale(String codiceFiscale) {
        this.codiceFiscale = codiceFiscale;
    }

    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    public Indirizzo getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(Indirizzo indirizzo) {
        this.indirizzo = indirizzo;
    }

    public Socio getSocio() {
        return socio;
    }

    public void setSocio(Socio socio) {
        this.socio = socio;
    }

    public Dipendente getDipendente() {
        return dipendente;
    }

    public void setDipendente(Dipendente dipendente) {
        this.dipendente = dipendente;
    }

    @PrePersist
    public void createAccount() {
        if (account == null) {
            Account acc = new Account();
            acc.setEmail(this.email);
            acc.setUltimoLogin(LocalDate.now());
            acc.setProfilo(this);
            setAccount(acc);
        }
    }
}
