package pwm.penna.model.dipendenti.pojo;

import java.io.Serializable;

public class Tecnico extends Dipendente implements Serializable {
    private String specializzazione;

    public String getSpecializzazione() {
        return specializzazione;
    }

    public void setSpecializzazione(String specializzazione) {
        this.specializzazione = specializzazione;
    }
}