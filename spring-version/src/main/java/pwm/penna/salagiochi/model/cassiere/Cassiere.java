package pwm.penna.salagiochi.model.cassiere;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import pwm.penna.salagiochi.model.assegna.Assegna;
import pwm.penna.salagiochi.model.dipendente.Dipendente;
import pwm.penna.salagiochi.model.salagiochi.SalaGiochi;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "cassiere")
@PrimaryKeyJoinColumn(name = "ID_Dipendente")
public class Cassiere extends Dipendente {

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "CodiceSalaGiochi", nullable = false)
    private SalaGiochi salaGiochi;

    @Column(name = "Sportello", nullable = false)
    private int sportello;

    @JsonIgnore
    @OneToMany(mappedBy = "cassiere", fetch = FetchType.LAZY)
    private Set<Assegna> assegnazioni = new HashSet<>();

    public SalaGiochi getSalaGiochi() {
        return salaGiochi;
    }

    public void setSalaGiochi(SalaGiochi salaGiochi) {
        this.salaGiochi = salaGiochi;
    }

    public int getSportello() {
        return sportello;
    }

    public void setSportello(int sportello) {
        this.sportello = sportello;
    }

    public Set<Assegna> getAssegnazioni() {
        return assegnazioni;
    }

    public void setAssegnazioni(Set<Assegna> assegnazioni) {
        this.assegnazioni = assegnazioni;
    }
}
