package pwm.penna.salagiochi.form.service;

import org.springframework.stereotype.Service;
import pwm.penna.salagiochi.form.dto.RichiedeForm;
import pwm.penna.salagiochi.form.service.base.BaseService;
import pwm.penna.salagiochi.model.cliente.Cliente;
import pwm.penna.salagiochi.model.richiede.Richiede;
import pwm.penna.salagiochi.model.richiede.RichiedeRepository;

import java.util.List;

@Service
public class RichiedeService extends BaseService<Richiede, RichiedeForm, Integer, RichiedeRepository> {

    public long countByConsole(Class<?> tipo) {
        return getRepository().countRichiestePerConsole(tipo);
    }

    public List<Richiede> byCliente(Cliente cliente) {
        return getRepository().findRichiesteByCliente(cliente);
    }

    public List<Richiede> nonAssegnate() {
        return getRepository().findRichiesteNonAssegnate();
    }
}
