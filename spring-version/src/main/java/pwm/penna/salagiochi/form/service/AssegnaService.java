package pwm.penna.salagiochi.form.service;

import org.springframework.stereotype.Service;
import pwm.penna.salagiochi.form.dto.AssegnazioneForm;
import pwm.penna.salagiochi.form.service.base.BaseService;
import pwm.penna.salagiochi.model.assegna.Assegna;
import pwm.penna.salagiochi.model.assegna.AssegnaRepository;

@Service
public class AssegnaService extends BaseService<Assegna, AssegnazioneForm, Integer, AssegnaRepository> {
}
