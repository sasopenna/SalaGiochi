package pwm.penna.salagiochi.web.controller.admin.dirigenza;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import pwm.penna.salagiochi.form.dto.SalaGiochiForm;
import pwm.penna.salagiochi.form.service.SalaGiochiService;
import pwm.penna.salagiochi.web.annotation.DirigenzaMapping;
import pwm.penna.salagiochi.web.controller.admin.dirigenza.base.BaseDirigenzaController;

@Controller
@DirigenzaMapping
@RequestMapping("/sala-giochi")
public class SalaGiochiDirigenzaController extends BaseDirigenzaController<SalaGiochiForm, Integer, SalaGiochiService> {

    @Override
    protected String getBasePath() {
        return "sala-giochi";
    }
}