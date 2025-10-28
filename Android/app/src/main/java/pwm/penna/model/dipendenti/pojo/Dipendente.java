package pwm.penna.model.dipendenti.pojo;

import java.io.Serializable;
import java.sql.Time;

import pwm.penna.model.profilo.Profilo;

public class Dipendente implements Serializable {
    private Integer idDipendente;
    private Profilo profilo;
    private Double salario;
    private Time inizioTurno;
    private Time fineTurno;

    public Integer getIdDipendente() {
        return idDipendente;
    }

    public void setIdDipendente(Integer idDipendente) {
        this.idDipendente = idDipendente;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public Time getInizioTurno() {
        return inizioTurno;
    }

    public void setInizioTurno(Time inizioTurno) {
        this.inizioTurno = inizioTurno;
    }

    public Time getFineTurno() {
        return fineTurno;
    }

    public void setFineTurno(Time fineTurno) {
        this.fineTurno = fineTurno;
    }

    public Profilo getProfilo() {
        return profilo;
    }

    public void setProfilo(Profilo profilo) {
        this.profilo = profilo;
    }

    public String toString() {
        return "[" + idDipendente + "] " + profilo.toString();
    }
}
