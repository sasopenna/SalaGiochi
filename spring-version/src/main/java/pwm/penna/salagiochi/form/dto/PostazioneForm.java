package pwm.penna.salagiochi.form.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import pwm.penna.salagiochi.form.dto.base.BaseForm;
import pwm.penna.salagiochi.model.dispositivodigioco.DispositivoDiGioco;
import pwm.penna.salagiochi.model.postazione.PostazioneId;

public class PostazioneForm extends BaseForm<PostazioneId> {

    private Integer numero;

    @Valid
    private PostazioneIdForm id = new PostazioneIdForm();

    @NotNull(message = "{validator.required}")
    private DispositivoDiGioco dispositivoDiGioco;

    // getters & setters
    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public PostazioneIdForm getId() {
        return id;
    }

    public void setId(PostazioneIdForm id) {
        this.id = id;
    }

    public DispositivoDiGioco getDispositivoDiGioco() {
        return dispositivoDiGioco;
    }

    public void setDispositivoDiGioco(DispositivoDiGioco dispositivoDiGioco) {
        this.dispositivoDiGioco = dispositivoDiGioco;
    }

    @Override
    public PostazioneId getKey() {
        return new PostazioneId(
                id.getSalaGiochi(),
                id.getStanza(),
                id.getPosto()
        );
    }

    @Override
    public void setKey(PostazioneId key) {
        PostazioneIdForm formId = new PostazioneIdForm();
        formId.setSalaGiochi(key.getSalaGiochi());
        formId.setStanza(key.getStanza());
        formId.setPosto(key.getPosto());
        setId(formId);
    }
}
