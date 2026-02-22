package pwm.penna.model.dipendenti.pojo;

import java.io.Serializable;

import pwm.penna.model.sale.SalaGiochi;

public class Cassiere extends Dipendente implements Serializable {
    private Integer sportello;
    private SalaGiochi salaGiochi;

    public Integer getSportello() {
        return sportello;
    }

    public void setSportello(Integer sportello) {
        this.sportello = sportello;
    }

    public SalaGiochi getSalaGiochi() {
        return salaGiochi;
    }

    public void setSalaGiochi(SalaGiochi salaGiochi) {
        this.salaGiochi = salaGiochi;
    }
}