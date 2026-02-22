package pwm.penna.salagiochi.model.assegna;

import jakarta.persistence.*;
import pwm.penna.salagiochi.model.cassiere.Cassiere;
import pwm.penna.salagiochi.model.richiede.Richiede;

import java.math.BigDecimal;
import java.time.LocalTime;

@Entity
@Table(name = "assegna")
public class Assegna {

    @Id
    @Column(name = "Prenotazione")
    private Integer prenotazione;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    @PrimaryKeyJoinColumn
    private Richiede richiede;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Cassiere", nullable = false)
    private Cassiere cassiere;

    @Column(name = "Costo", nullable = false, precision = 5, scale = 2)
    private BigDecimal costo;

    @Column(name = "Orario", nullable = false)
    private LocalTime orario;

    public Integer getPrenotazione() {
        return prenotazione;
    }

    public void setPrenotazione(Integer prenotazione) {
        this.prenotazione = prenotazione;
    }

    public Richiede getRichiede() {
        return richiede;
    }

    public void setRichiede(Richiede richiede) {
        this.richiede = richiede;
    }

    public Cassiere getCassiere() {
        return cassiere;
    }

    public void setCassiere(Cassiere cassiere) {
        this.cassiere = cassiere;
    }

    public BigDecimal getCosto() {
        return costo;
    }

    public void setCosto(BigDecimal costo) {
        this.costo = costo;
    }

    public LocalTime getOrario() {
        return orario;
    }

    public void setOrario(LocalTime orario) {
        this.orario = orario;
    }
}
