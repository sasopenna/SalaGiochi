package pwm.penna.salagiochi.model.tecnico;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import pwm.penna.salagiochi.model.dipendente.Dipendente;
import pwm.penna.salagiochi.model.ripara.Ripara;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tecnico")
@PrimaryKeyJoinColumn(name = "ID_Dipendente")
public class Tecnico extends Dipendente {

    @Column(name = "Specializzazione", nullable = false)
    private String specializzazione;

    @JsonIgnore
    @OneToMany(mappedBy = "tecnico", fetch = FetchType.LAZY)
    private Set<Ripara> riparazioni = new HashSet<>();

    public String getSpecializzazione() {
        return specializzazione;
    }

    public void setSpecializzazione(String specializzazione) {
        this.specializzazione = specializzazione;
    }

    public Set<Ripara> getRiparazioni() {
        return riparazioni;
    }

    public void setRiparazioni(Set<Ripara> riparazioni) {
        this.riparazioni = riparazioni;
    }
}
