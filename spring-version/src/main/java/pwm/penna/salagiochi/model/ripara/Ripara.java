package pwm.penna.salagiochi.model.ripara;

import jakarta.persistence.*;
import pwm.penna.salagiochi.model.dispositivodigioco.DispositivoDiGioco;
import pwm.penna.salagiochi.model.tecnico.Tecnico;

import java.math.BigDecimal;

@Entity
@Table(name = "ripara")
public class Ripara {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Progressivo")
    private int progressivo;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "DispositivoDiGioco", nullable = false)
    private DispositivoDiGioco dispositivoDiGioco;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Tecnico", nullable = false)
    private Tecnico tecnico;

    @Column(name = "CostoRiparazione", nullable = false, precision = 5, scale = 2)
    private BigDecimal costoRiparazione;

    public int getProgressivo() {
        return progressivo;
    }

    public void setProgressivo(int progressivo) {
        this.progressivo = progressivo;
    }

    public DispositivoDiGioco getDispositivoDiGioco() {
        return dispositivoDiGioco;
    }

    public void setDispositivoDiGioco(DispositivoDiGioco dispositivoDiGioco) {
        this.dispositivoDiGioco = dispositivoDiGioco;
    }

    public Tecnico getTecnico() {
        return tecnico;
    }

    public void setTecnico(Tecnico tecnico) {
        this.tecnico = tecnico;
    }

    public BigDecimal getCostoRiparazione() {
        return costoRiparazione;
    }

    public void setCostoRiparazione(BigDecimal costoRiparazione) {
        this.costoRiparazione = costoRiparazione;
    }
}
