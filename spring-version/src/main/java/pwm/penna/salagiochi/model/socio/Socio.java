package pwm.penna.salagiochi.model.socio;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import pwm.penna.salagiochi.model.cliente.Cliente;
import pwm.penna.salagiochi.model.profilo.Profilo;

import java.time.LocalDate;

@Entity
@Table(name = "socio")
public class Socio {

    @Id
    @Column(name = "NumeroCliente")
    private Integer numeroCliente;

    @JsonIgnore
    @OneToOne(fetch = FetchType.EAGER)
    @PrimaryKeyJoinColumn
    private Cliente cliente;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "Email", nullable = false, unique = true)
    private Profilo profilo;

    @Column(name = "Punteggio", nullable = false)
    private int punteggio;

    @Column(name = "MembroDal", nullable = false)
    private LocalDate membroDal;

    public Integer getNumeroCliente() {
        return numeroCliente;
    }

    public void setNumeroCliente(Integer numeroCliente) {
        this.numeroCliente = numeroCliente;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Profilo getProfilo() {
        return profilo;
    }

    public void setProfilo(Profilo profilo) {
        this.profilo = profilo;
    }

    public int getPunteggio() {
        return punteggio;
    }

    public void setPunteggio(int punteggio) {
        this.punteggio = punteggio;
    }

    public LocalDate getMembroDal() {
        return membroDal;
    }

    public void setMembroDal(LocalDate membroDal) {
        this.membroDal = membroDal;
    }
}
