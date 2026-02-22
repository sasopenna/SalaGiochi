package pwm.penna.salagiochi.form.service;

import org.springframework.stereotype.Service;
import pwm.penna.salagiochi.form.dto.CassiereForm;
import pwm.penna.salagiochi.form.service.base.BaseService;
import pwm.penna.salagiochi.model.cassiere.Cassiere;
import pwm.penna.salagiochi.model.cassiere.CassiereRepository;

@Service
public class CassiereService extends BaseService<Cassiere, CassiereForm, Integer, CassiereRepository> {
}