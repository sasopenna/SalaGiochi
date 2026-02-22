package pwm.penna.salagiochi.web.controller.admin.dirigenza;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pwm.penna.salagiochi.form.dto.DispositivoDiGiocoForm;
import pwm.penna.salagiochi.form.service.DispositivoDiGiocoService;
import pwm.penna.salagiochi.form.validator.ddg.PlayStationValidator;
import pwm.penna.salagiochi.form.validator.ddg.WindowsValidator;
import pwm.penna.salagiochi.form.validator.ddg.XboxValidator;
import pwm.penna.salagiochi.web.annotation.DirigenzaMapping;
import pwm.penna.salagiochi.web.controller.admin.dirigenza.base.BaseDirigenzaController;

@Controller
@DirigenzaMapping
@RequestMapping("/dispositivo-di-gioco")
public class DispositivoDiGiocoDirigenzaController extends BaseDirigenzaController<DispositivoDiGiocoForm, Integer, DispositivoDiGiocoService> {

    @Autowired
    private PlayStationValidator playStationValidator;
    @Autowired
    private XboxValidator xboxValidator;
    @Autowired
    private WindowsValidator windowsValidator;

    @Override
    protected String getBasePath() {
        return "dispositivo-di-gioco";
    }

    @Override
    protected void buildModel(Model model, Integer id) {
        model.addAttribute("discriminatorPlayStation", playStationValidator.getLista());
        model.addAttribute("discriminatorXbox", xboxValidator.getLista());
        model.addAttribute("discriminatorWindows", windowsValidator.getLista());
    }
}
