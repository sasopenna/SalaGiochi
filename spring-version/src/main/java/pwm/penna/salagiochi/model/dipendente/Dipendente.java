package pwm.penna.salagiochi.model.dipendente;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import pwm.penna.salagiochi.model.profilo.Profilo;

import java.math.BigDecimal;
import java.time.LocalTime;

@Entity
@Table(name = "dipendente")
@Inheritance(strategy = InheritanceType.JOINED)
public class Dipendente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Dipendente")
    private Integer idDipendente;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "Email", nullable = false, unique = true)
    private Profilo profilo;

    @Column(name = "Salario", nullable = false, precision = 9, scale = 2)
    private BigDecimal salario;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "'0000-00-00T'HH:mm:ss") // Retrocompatibilità
    @Column(name = "InizioTurno", nullable = false)
    private LocalTime inizioTurno;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "'0000-00-00T'HH:mm:ss") // Retrocompatibilità
    @Column(name = "FineTurno", nullable = false)
    private LocalTime fineTurno;

    public Integer getIdDipendente() {
        return idDipendente;
    }

    public void setIdDipendente(Integer idDipendente) {
        this.idDipendente = idDipendente;
    }

    public Profilo getProfilo() {
        return profilo;
    }

    public void setProfilo(Profilo profilo) {
        this.profilo = profilo;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public LocalTime getInizioTurno() {
        return inizioTurno;
    }

    public void setInizioTurno(LocalTime inizioTurno) {
        this.inizioTurno = inizioTurno;
    }

    public LocalTime getFineTurno() {
        return fineTurno;
    }

    public void setFineTurno(LocalTime fineTurno) {
        this.fineTurno = fineTurno;
    }
}
