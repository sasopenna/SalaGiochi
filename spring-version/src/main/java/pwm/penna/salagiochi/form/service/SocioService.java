package pwm.penna.salagiochi.form.service;

import org.springframework.stereotype.Service;
import pwm.penna.salagiochi.form.dto.SocioForm;
import pwm.penna.salagiochi.form.service.base.BaseService;
import pwm.penna.salagiochi.model.socio.Socio;
import pwm.penna.salagiochi.model.socio.SocioRepository;

@Service
public class SocioService extends BaseService<Socio, SocioForm, Integer, SocioRepository> {
}
