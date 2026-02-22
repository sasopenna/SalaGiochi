package pwm.penna.salagiochi.model.postazione;

import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.*;
import pwm.penna.salagiochi.model.salagiochi.SalaGiochi;
import pwm.penna.salagiochi.web.controller.api.ApiView;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class PostazioneId implements Serializable {

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "CodiceSalaGiochi", insertable = false, updatable = false)
    private SalaGiochi salaGiochi;

    @JsonView(ApiView.Postazione.class)
    @Column(name = "Stanza")
    private int stanza;

    @JsonView(ApiView.Postazione.class)
    @Column(name = "Posto")
    private int posto;

    public PostazioneId() {
    }

    public PostazioneId(SalaGiochi salaGiochi, int stanza, int posto) {
        this.salaGiochi = salaGiochi;
        this.stanza = stanza;
        this.posto = posto;
    }

    public SalaGiochi getSalaGiochi() {
        return salaGiochi;
    }

    public void setSalaGiochi(SalaGiochi salaGiochi) {
        this.salaGiochi = salaGiochi;
    }

    public int getStanza() {
        return stanza;
    }

    public void setStanza(int stanza) {
        this.stanza = stanza;
    }

    public int getPosto() {
        return posto;
    }

    public void setPosto(int posto) {
        this.posto = posto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PostazioneId that)) return false;
        return salaGiochi == that.salaGiochi &&
                stanza == that.stanza &&
                posto == that.posto;
    }

    @Override
    public int hashCode() {
        return Objects.hash(salaGiochi, stanza, posto);
    }
}
