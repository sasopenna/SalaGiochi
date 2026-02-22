package pwm.penna.salagiochi.form.service;

import org.springframework.stereotype.Service;
import pwm.penna.salagiochi.form.dto.PostazioneForm;
import pwm.penna.salagiochi.form.service.base.BaseService;
import pwm.penna.salagiochi.model.dispositivodigioco.tipo.PC;
import pwm.penna.salagiochi.model.dispositivodigioco.tipo.PlayStation;
import pwm.penna.salagiochi.model.dispositivodigioco.tipo.Xbox;
import pwm.penna.salagiochi.model.postazione.Postazione;
import pwm.penna.salagiochi.model.postazione.PostazioneId;
import pwm.penna.salagiochi.model.postazione.PostazioneRepository;

import java.util.List;

@Service
public class PostazioneService extends BaseService<Postazione, PostazioneForm, PostazioneId, PostazioneRepository> {
    private Class<?> getTipoClass(String tipo) {
        return switch (tipo) {
            case "PC" -> PC.class;
            case "Xbox" -> Xbox.class;
            case "PlayStation" -> PlayStation.class;
            default -> throw new IllegalArgumentException("Tipo non valido: " + tipo);
        };
    }

    public List<Postazione> cercaPostazioni(String codice, String tipo) {
        return getRepository().findBySalaAndTipo(codice, getTipoClass(tipo));
    }
}
