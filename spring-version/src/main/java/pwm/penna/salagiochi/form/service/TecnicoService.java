package pwm.penna.salagiochi.form.service;

import org.springframework.stereotype.Service;
import pwm.penna.salagiochi.form.dto.TecnicoForm;
import pwm.penna.salagiochi.form.service.base.BaseService;
import pwm.penna.salagiochi.model.tecnico.Tecnico;
import pwm.penna.salagiochi.model.tecnico.TecnicoRepository;

@Service
public class TecnicoService extends BaseService<Tecnico, TecnicoForm, Integer, TecnicoRepository> {
}