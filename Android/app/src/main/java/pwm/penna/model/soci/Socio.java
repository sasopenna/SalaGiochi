package pwm.penna.model.soci;

import java.io.Serializable;
import java.sql.Date;

import pwm.penna.model.profilo.Profilo;

public class Socio implements Serializable {
    private Integer numeroCliente;
    private Profilo profilo;
    private int punteggio;
    private Date membroDal;

    Socio() {}

    public Integer getNumeroCliente() {
        return numeroCliente;
    }

    public void setNumeroCliente(Integer numeroCliente) {
        this.numeroCliente = numeroCliente;
    }

    public int getPunteggio() {
        return punteggio;
    }

    public void setPunteggio(int punteggio) {
        this.punteggio = punteggio;
    }

    public Date getMembroDal() {
        return membroDal;
    }

    public void setMembroDal(Date membroDal) {
        this.membroDal = membroDal;
    }

    public Profilo getProfilo() {
        return profilo;
    }

    public void setProfilo(Profilo profilo) {
        this.profilo = profilo;
    }

    public String toString() {
        return "[" + numeroCliente + "] " + profilo.toString();
    }
}
