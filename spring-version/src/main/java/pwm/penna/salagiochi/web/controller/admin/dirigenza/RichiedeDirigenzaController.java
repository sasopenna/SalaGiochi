package pwm.penna.salagiochi.web.controller.admin.dirigenza;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pwm.penna.salagiochi.form.dto.RichiedeForm;
import pwm.penna.salagiochi.form.service.ClienteService;
import pwm.penna.salagiochi.form.service.PostazioneService;
import pwm.penna.salagiochi.form.service.RichiedeService;
import pwm.penna.salagiochi.web.annotation.DirigenzaMapping;
import pwm.penna.salagiochi.web.controller.admin.dirigenza.base.BaseDirigenzaController;

@Controller
@DirigenzaMapping
@RequestMapping("/richiede")
public class RichiedeDirigenzaController extends BaseDirigenzaController<RichiedeForm, Integer, RichiedeService> {

    @Autowired
    private ClienteService clienteService;
    @Autowired
    private PostazioneService postazioneService;

    @Override
    protected String getBasePath() {
        return "richiede";
    }

    @Override
    protected void buildModel(Model model, Integer id) {
        model.addAttribute("clienti", clienteService.lista());
        model.addAttribute("postazioni", postazioneService.lista());
    }
}
