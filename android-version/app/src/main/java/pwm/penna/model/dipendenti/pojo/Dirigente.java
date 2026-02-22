package pwm.penna.model.dipendenti.pojo;

import java.io.Serializable;
import java.util.List;

import pwm.penna.model.sale.SalaGiochi;

public class Dirigente extends Dipendente implements Serializable {
    private Integer esperienza;
    private Integer periodo;
    private List<SalaGiochi> sale;

    public int getEsperienza() {
        return esperienza;
    }

    public void setEsperienza(Integer esperienza) {
        this.esperienza = esperienza;
    }

    public Integer getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Integer periodo) {
        this.periodo = periodo;
    }

    public List<SalaGiochi> getSale() {
        return sale;
    }

    public void setSale(List<SalaGiochi> sale) {
        this.sale = sale;
    }
}