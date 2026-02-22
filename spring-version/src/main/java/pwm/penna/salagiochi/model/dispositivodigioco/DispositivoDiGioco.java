package pwm.penna.salagiochi.model.dispositivodigioco;

import jakarta.persistence.*;
import pwm.penna.salagiochi.model.postazione.Postazione;
import pwm.penna.salagiochi.model.ripara.Ripara;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "dispositivo_di_gioco")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "Tipo", discriminatorType = DiscriminatorType.STRING)
public class DispositivoDiGioco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "DataAcquisizione", nullable = false)
    private LocalDate dataAcquisizione;

    @OneToOne(mappedBy = "dispositivoDiGioco", fetch = FetchType.EAGER)
    private Postazione postazione;

    @OneToMany(mappedBy = "dispositivoDiGioco", fetch = FetchType.LAZY)
    private Set<Ripara> riparazioni = new HashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getDataAcquisizione() {
        return dataAcquisizione;
    }

    public void setDataAcquisizione(LocalDate dataAcquisizione) {
        this.dataAcquisizione = dataAcquisizione;
    }

    public Postazione getPostazione() {
        return postazione;
    }

    public void setPostazione(Postazione postazione) {
        this.postazione = postazione;
    }

    public Set<Ripara> getRiparazioni() {
        return riparazioni;
    }

    public void setRiparazioni(Set<Ripara> riparazioni) {
        this.riparazioni = riparazioni;
    }

    public String getTipo() {
        return this.getClass().getSimpleName();
    }
}
