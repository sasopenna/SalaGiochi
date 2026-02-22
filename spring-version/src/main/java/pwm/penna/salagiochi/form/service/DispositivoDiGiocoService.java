package pwm.penna.salagiochi.form.service;

import org.springframework.stereotype.Service;
import pwm.penna.salagiochi.form.dto.DispositivoDiGiocoForm;
import pwm.penna.salagiochi.form.service.base.BaseService;
import pwm.penna.salagiochi.model.dispositivodigioco.DispositivoDiGioco;
import pwm.penna.salagiochi.model.dispositivodigioco.DispositivoDiGiocoRepository;

import java.util.List;

@Service
public class DispositivoDiGiocoService extends BaseService<DispositivoDiGioco, DispositivoDiGiocoForm, Integer, DispositivoDiGiocoRepository> {

    public List<DispositivoDiGioco> withoutPostazione() {
        return getRepository().withoutPostazione();
    }
}
