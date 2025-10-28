package pwm.penna.model.profilo;

import java.io.Serializable;
import java.sql.Date;

public class Profilo implements Serializable {
    private static final long serialVersionUID = 1L;

    private String email;
    private String nome;
    private String cognome;
    private String sesso;
    private Date dataDiNascita;
    private String codiceFiscale;
    private long telefono;
    private String via;
    private int numeroCivico;
    private String citta;
    private int cap;

    public Profilo() {
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return this.cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getSesso() {
        return this.sesso;
    }

    public void setSesso(String sesso) {
        this.sesso = sesso;
    }

    public Date getDataDiNascita() {
        return this.dataDiNascita;
    }

    public void setDataDiNascita(Date dataDiNascita) {
        this.dataDiNascita = dataDiNascita;
    }

    public String getCodiceFiscale() {
        return this.codiceFiscale;
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

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getVia() {
        return this.via;
    }

    public void setVia(String via) {
        this.via = via;
    }

    public int getNumeroCivico() {
        return this.numeroCivico;
    }

    public void setNumeroCivico(int numeroCivico) {
        this.numeroCivico = numeroCivico;
    }

    public String getCitta() {
        return citta;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }

    public int getCap() {
        return this.cap;
    }

    public void setCap(int cap) {
        this.cap = cap;
    }

    public String toString() {
        return nome + " " + cognome;
    }
}
