package pwm.penna.salagiochi.form.service;

import org.springframework.stereotype.Service;
import pwm.penna.salagiochi.form.dto.SalaGiochiForm;
import pwm.penna.salagiochi.form.service.base.BaseService;
import pwm.penna.salagiochi.model.salagiochi.SalaGiochi;
import pwm.penna.salagiochi.model.salagiochi.SalaGiochiRepository;

@Service
public class SalaGiochiService extends BaseService<SalaGiochi, SalaGiochiForm, Integer, SalaGiochiRepository> {
}
