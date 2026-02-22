package pwm.penna.salagiochi.model.dispositivodigioco.tipo;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import pwm.penna.salagiochi.model.dispositivodigioco.DispositivoDiGioco;

@Entity
@DiscriminatorValue("PlayStation")
public class PlayStation extends DispositivoDiGioco {

    @Column(name = "generazione")
    private String generazione;

    public String getGenerazione() {
        return generazione;
    }

    public void setGenerazione(String generazione) {
        this.generazione = generazione;
    }
}
