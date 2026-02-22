package pwm.penna.salagiochi.form.service;

import org.springframework.stereotype.Service;
import pwm.penna.salagiochi.form.dto.RiparaForm;
import pwm.penna.salagiochi.form.service.base.BaseService;
import pwm.penna.salagiochi.model.ripara.Ripara;
import pwm.penna.salagiochi.model.ripara.RiparaRepository;

@Service
public class RiparaService extends BaseService<Ripara, RiparaForm, Integer, RiparaRepository> {
}
