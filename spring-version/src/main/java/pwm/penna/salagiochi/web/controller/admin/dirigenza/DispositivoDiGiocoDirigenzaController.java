package pwm.penna.salagiochi.web.controller.admin.dirigenza;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import pwm.penna.salagiochi.form.dto.DispositivoDiGiocoForm;
import pwm.penna.salagiochi.form.service.DispositivoDiGiocoService;
import pwm.penna.salagiochi.form.validator.PlayStationValidator;
import pwm.penna.salagiochi.form.validator.WindowsValidator;
import pwm.penna.salagiochi.form.validator.XboxValidator;
import pwm.penna.salagiochi.form.validator.base.BaseListValidator;
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

    @Override
    public void formBinding(DispositivoDiGiocoForm form, BindingResult bindingResult) {
        BaseListValidator<?> validator = switch (form.getTipo()) {
            case "PC" -> windowsValidator;
            case "Xbox" -> xboxValidator;
            case "PlayStation" -> playStationValidator;
            default -> null;
        };

        if (validator == null || !validator.getLista().contains(form.getDiscriminator())) {
            bindingResult.rejectValue("discriminator", "validator.invalid_version");
        }
    }
}
