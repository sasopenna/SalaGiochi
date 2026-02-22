package pwm.penna.salagiochi.model.salagiochi;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import pwm.penna.salagiochi.model.dirigente.Dirigente;
import pwm.penna.salagiochi.model.postazione.Postazione;

import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "sala_giochi")
public class SalaGiochi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Codice")
    private Integer codice;

    @Column(name = "Nome", length = 50, nullable = false)
    private String nome;

    @Column(name = "Capienza", nullable = false)
    private int capienza;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "'0000-00-00T'HH:mm:ss") // Retrocompatibilità
    @Column(name = "OrarioApertura", nullable = false)
    private LocalTime orarioApertura;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "'0000-00-00T'HH:mm:ss") // Retrocompatibilità
    @Column(name = "OrarioChiusura", nullable = false)
    private LocalTime orarioChiusura;

    @Embedded
    private Indirizzo indirizzo;

    @JsonIgnore
    @ManyToMany(mappedBy = "sale", fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    private Set<Dirigente> dirigenti = new HashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy = "id.salaGiochi", fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    private Set<Postazione> postazioni = new HashSet<>();

    public Integer getCodice() {
        return codice;
    }

    public void setCodice(Integer codice) {
        this.codice = codice;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCapienza() {
        return capienza;
    }

    public void setCapienza(int capienza) {
        this.capienza = capienza;
    }

    public LocalTime getOrarioApertura() {
        return orarioApertura;
    }

    public void setOrarioApertura(LocalTime orarioApertura) {
        this.orarioApertura = orarioApertura;
    }

    public LocalTime getOrarioChiusura() {
        return orarioChiusura;
    }

    public void setOrarioChiusura(LocalTime orarioChiusura) {
        this.orarioChiusura = orarioChiusura;
    }

    public Indirizzo getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(Indirizzo indirizzo) {
        this.indirizzo = indirizzo;
    }

    public Set<Dirigente> getDirigenti() {
        return dirigenti;
    }

    public void setDirigenti(Set<Dirigente> dirigenti) {
        this.dirigenti = dirigenti;
    }

    public Set<Postazione> getPostazioni() {
        return postazioni;
    }

    public void setPostazioni(Set<Postazione> postazioni) {
        this.postazioni = postazioni;
    }
}
