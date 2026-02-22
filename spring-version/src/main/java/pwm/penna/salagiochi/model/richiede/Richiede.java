package pwm.penna.salagiochi.model.richiede;

import jakarta.persistence.*;
import pwm.penna.salagiochi.model.assegna.Assegna;
import pwm.penna.salagiochi.model.cliente.Cliente;
import pwm.penna.salagiochi.model.postazione.Postazione;

import java.time.LocalTime;

@Entity
@Table(name = "richiede")
public class Richiede {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Prenotazione")
    private Integer prenotazione;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Cliente", nullable = false)
    private Cliente cliente;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Postazione", nullable = false, referencedColumnName = "Numero")
    private Postazione postazione;

    @Column(name = "Durata", nullable = false)
    private LocalTime durata;

    @OneToOne(mappedBy = "richiede", fetch = FetchType.EAGER)
    private Assegna assegnazione;

    public Integer getPrenotazione() {
        return prenotazione;
    }

    public void setPrenotazione(Integer prenotazione) {
        this.prenotazione = prenotazione;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Postazione getPostazione() {
        return postazione;
    }

    public void setPostazione(Postazione postazione) {
        this.postazione = postazione;
    }

    public LocalTime getDurata() {
        return durata;
    }

    public void setDurata(LocalTime durata) {
        this.durata = durata;
    }

    public Assegna getAssegnazione() {
        return assegnazione;
    }

    public void setAssegnazione(Assegna assegnazione) {
        this.assegnazione = assegnazione;
    }
}
