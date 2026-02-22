package pwm.penna.salagiochi.form.service;

import org.springframework.stereotype.Service;
import pwm.penna.salagiochi.form.dto.DirigenteForm;
import pwm.penna.salagiochi.form.service.base.BaseService;
import pwm.penna.salagiochi.model.dirigente.Dirigente;
import pwm.penna.salagiochi.model.dirigente.DirigenteRepository;

@Service
public class DirigenteService extends BaseService<Dirigente, DirigenteForm, Integer, DirigenteRepository> {
}
