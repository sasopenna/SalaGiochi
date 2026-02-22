package pwm.penna.salagiochi.web.controller.admin.dirigenza;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pwm.penna.salagiochi.form.dto.SocioForm;
import pwm.penna.salagiochi.form.service.ClienteService;
import pwm.penna.salagiochi.form.service.SocioService;
import pwm.penna.salagiochi.web.annotation.DirigenzaMapping;
import pwm.penna.salagiochi.web.controller.admin.dirigenza.base.BaseDirigenzaController;

@Controller
@DirigenzaMapping
@RequestMapping("/socio")
public class SocioDirigenzaController extends BaseDirigenzaController<SocioForm, Integer, SocioService> {

    @Autowired
    private ClienteService clienteService;

    @Override
    protected String getBasePath() {
        return "socio";
    }

    @Override
    protected void buildModel(Model model, Integer id) {
        model.addAttribute("notSoci", clienteService.notSoci());
    }
}
