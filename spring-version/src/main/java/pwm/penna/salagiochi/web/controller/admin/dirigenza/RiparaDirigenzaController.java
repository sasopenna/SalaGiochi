package pwm.penna.salagiochi.web.controller.admin.dirigenza;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pwm.penna.salagiochi.form.dto.RiparaForm;
import pwm.penna.salagiochi.form.service.DispositivoDiGiocoService;
import pwm.penna.salagiochi.form.service.RiparaService;
import pwm.penna.salagiochi.form.service.TecnicoService;
import pwm.penna.salagiochi.web.annotation.DirigenzaMapping;
import pwm.penna.salagiochi.web.controller.admin.dirigenza.base.BaseDirigenzaController;

@Controller
@DirigenzaMapping
@RequestMapping("/ripara")
public class RiparaDirigenzaController extends BaseDirigenzaController<RiparaForm, Integer, RiparaService> {

    @Autowired
    private TecnicoService tecnicoService;
    @Autowired
    private DispositivoDiGiocoService dispositivoDiGiocoService;

    @Override
    protected String getBasePath() {
        return "ripara";
    }

    @Override
    protected void buildModel(Model model, Integer id) {
        model.addAttribute("tecnici", tecnicoService.lista());
        model.addAttribute("dispositivi", dispositivoDiGiocoService.lista());
    }
}
