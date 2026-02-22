package pwm.penna.salagiochi.form.dto;

import jakarta.validation.constraints.NotNull;
import pwm.penna.salagiochi.form.dto.base.BaseForm;
import pwm.penna.salagiochi.model.cliente.Cliente;
import pwm.penna.salagiochi.model.postazione.Postazione;

public class RichiedeForm extends BaseForm<Integer> {

    private Integer prenotazione;

    @NotNull(message = "{validator.required}")
    private Cliente cliente;

    @NotNull(message = "{validator.required}")
    private Postazione postazione;

    @NotNull(message = "{validator.required}")
    private String durata;

    // getters & setters
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

    public String getDurata() {
        return durata;
    }

    public void setDurata(String durata) {
        this.durata = durata;
    }

    @Override
    public Integer getKey() {
        return getPrenotazione();
    }

    @Override
    public void setKey(Integer key) {
        setPrenotazione(key);
    }
}
