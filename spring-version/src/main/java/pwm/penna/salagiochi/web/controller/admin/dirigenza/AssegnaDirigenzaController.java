package pwm.penna.salagiochi.web.controller.admin.dirigenza;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pwm.penna.salagiochi.form.dto.AssegnazioneForm;
import pwm.penna.salagiochi.form.service.AssegnaService;
import pwm.penna.salagiochi.form.service.CassiereService;
import pwm.penna.salagiochi.form.service.RichiedeService;
import pwm.penna.salagiochi.web.annotation.DirigenzaMapping;
import pwm.penna.salagiochi.web.controller.admin.dirigenza.base.BaseDirigenzaController;

@Controller
@DirigenzaMapping
@RequestMapping("/assegna")
public class AssegnaDirigenzaController extends BaseDirigenzaController<AssegnazioneForm, Integer, AssegnaService> {
    @Autowired
    private CassiereService cassiereService;
    @Autowired
    private RichiedeService richiedeService;

    @Override
    protected String getBasePath() {
        return "assegna";
    }

    @Override
    protected void buildModel(Model model, Integer id) {
        model.addAttribute("cassieri", cassiereService.lista());
        model.addAttribute("richieste", richiedeService.nonAssegnate());
    }
}
