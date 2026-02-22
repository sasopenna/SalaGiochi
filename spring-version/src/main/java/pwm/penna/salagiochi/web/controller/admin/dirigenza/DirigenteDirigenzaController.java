package pwm.penna.salagiochi.web.controller.admin.dirigenza;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pwm.penna.salagiochi.form.dto.DirigenteForm;
import pwm.penna.salagiochi.form.service.DirigenteService;
import pwm.penna.salagiochi.form.service.SalaGiochiService;
import pwm.penna.salagiochi.web.annotation.DirigenzaMapping;
import pwm.penna.salagiochi.web.controller.admin.dirigenza.base.BaseDirigenzaController;

@Controller
@DirigenzaMapping
@RequestMapping("/dirigente")
public class DirigenteDirigenzaController extends BaseDirigenzaController<DirigenteForm, Integer, DirigenteService> {
    @Autowired
    private SalaGiochiService salaGiochiService;

    @Override
    protected String getBasePath() {
        return "dirigente";
    }

    @Override
    protected void buildModel(Model model, Integer id) {
        model.addAttribute("sale", salaGiochiService.lista());
    }
}