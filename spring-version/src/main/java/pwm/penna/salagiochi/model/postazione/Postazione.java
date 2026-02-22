package pwm.penna.salagiochi.model.postazione;

import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.*;
import pwm.penna.salagiochi.model.dispositivodigioco.DispositivoDiGioco;
import pwm.penna.salagiochi.model.richiede.Richiede;
import pwm.penna.salagiochi.web.controller.api.ApiView;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "postazione")
public class Postazione {

    @JsonView(ApiView.Postazione.class)
    @Column(name = "Numero", nullable = false, unique = true)
    private int numero;

    @JsonView(ApiView.Postazione.class)
    @EmbeddedId
    private PostazioneId id;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "DispositivoDiGioco", nullable = false, unique = true)
    private DispositivoDiGioco dispositivoDiGioco;

    @OneToMany(mappedBy = "postazione", fetch = FetchType.LAZY)
    private Set<Richiede> richieste = new HashSet<>();

    public PostazioneId getId() {
        return id;
    }

    public void setId(PostazioneId id) {
        this.id = id;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public DispositivoDiGioco getDispositivoDiGioco() {
        return dispositivoDiGioco;
    }

    public void setDispositivoDiGioco(DispositivoDiGioco dispositivoDiGioco) {
        this.dispositivoDiGioco = dispositivoDiGioco;
    }

    public Set<Richiede> getRichieste() {
        return richieste;
    }

    public void setRichieste(Set<Richiede> richieste) {
        this.richieste = richieste;
    }
}
