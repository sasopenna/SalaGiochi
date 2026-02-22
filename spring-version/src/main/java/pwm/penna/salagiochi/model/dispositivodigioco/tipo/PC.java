package pwm.penna.salagiochi.model.dispositivodigioco.tipo;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import pwm.penna.salagiochi.model.dispositivodigioco.DispositivoDiGioco;

@Entity
@DiscriminatorValue("PC")
public class PC extends DispositivoDiGioco {

    @Column(name = "Windows")
    private String windows;

    public String getWindows() {
        return windows;
    }

    public void setWindows(String windows) {
        this.windows = windows;
    }
}
