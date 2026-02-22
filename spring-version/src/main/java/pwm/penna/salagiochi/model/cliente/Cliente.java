package pwm.penna.salagiochi.model.cliente;

import jakarta.persistence.*;
import pwm.penna.salagiochi.model.richiede.Richiede;
import pwm.penna.salagiochi.model.socio.Socio;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "NumeroCliente")
    private Integer numeroCliente;

    @OneToMany(mappedBy = "cliente", fetch = FetchType.EAGER)
    private Set<Richiede> richieste = new HashSet<>();

    @OneToOne(fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn
    private Socio socio;

    public Integer getNumeroCliente() {
        return numeroCliente;
    }

    public void setNumeroCliente(Integer numeroCliente) {
        this.numeroCliente = numeroCliente;
    }

    public Set<Richiede> getRichieste() {
        return richieste;
    }

    public void setRichieste(Set<Richiede> richieste) {
        this.richieste = richieste;
    }

    public Socio getSocio() {
        return socio;
    }

    public void setSocio(Socio socio) {
        this.socio = socio;
    }
}
