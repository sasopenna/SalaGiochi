package pwm.penna.salagiochi.web.controller.admin.dirigenza;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import pwm.penna.salagiochi.form.dto.TecnicoForm;
import pwm.penna.salagiochi.form.service.TecnicoService;
import pwm.penna.salagiochi.web.annotation.DirigenzaMapping;
import pwm.penna.salagiochi.web.controller.admin.dirigenza.base.BaseDirigenzaController;

@Controller
@DirigenzaMapping
@RequestMapping("/tecnico")
public class TecnicoDirigenzaController extends BaseDirigenzaController<TecnicoForm, Integer, TecnicoService> {

    @Override
    protected String getBasePath() {
        return "tecnico";
    }
}