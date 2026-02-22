package pwm.penna.salagiochi.model.dirigente;

import jakarta.persistence.*;
import pwm.penna.salagiochi.model.dipendente.Dipendente;
import pwm.penna.salagiochi.model.salagiochi.SalaGiochi;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "dirigente")
@PrimaryKeyJoinColumn(name = "ID_Dipendente")
public class Dirigente extends Dipendente {

    @Column(name = "Esperienza", nullable = false)
    private int esperienza;

    @Column(name = "Periodo", nullable = false)
    private int periodo;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinTable(
            name = "dirigente_salagiochi",
            joinColumns = @JoinColumn(name = "Dirigente"),
            inverseJoinColumns = @JoinColumn(name = "SalaGiochi")
    )
    private Set<SalaGiochi> sale = new HashSet<>();

    public int getEsperienza() {
        return esperienza;
    }

    public void setEsperienza(int esperienza) {
        this.esperienza = esperienza;
    }

    public int getPeriodo() {
        return periodo;
    }

    public void setPeriodo(int periodo) {
        this.periodo = periodo;
    }

    public Set<SalaGiochi> getSale() {
        return sale;
    }

    public void setSale(Set<SalaGiochi> sale) {
        this.sale = sale;
    }
}
