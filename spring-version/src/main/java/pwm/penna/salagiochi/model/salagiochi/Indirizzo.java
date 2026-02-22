package pwm.penna.salagiochi.model.salagiochi;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class Indirizzo {

    @Column(name = "Via", length = 100, nullable = false)
    private String via;

    @Column(name = "NumeroCivico", nullable = false)
    private int numeroCivico;

    @Column(name = "Città", length = 100, nullable = false)
    private String citta;

    @Column(name = "CAP", nullable = false)
    private int cap;

    @Column(name = "Provincia", length = 100)
    private String provincia;

    @Column(name = "Regione", length = 100)
    private String regione;

    public String getVia() {
        return via;
    }

    public void setVia(String via) {
        this.via = via;
    }

    public int getNumeroCivico() {
        return numeroCivico;
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
        return cap;
    }

    public void setCap(int cap) {
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
