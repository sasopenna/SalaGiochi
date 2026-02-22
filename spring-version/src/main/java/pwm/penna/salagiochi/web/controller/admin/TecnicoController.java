package pwm.penna.salagiochi.web.controller.admin;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pwm.penna.salagiochi.form.dto.RiparaForm;
import pwm.penna.salagiochi.form.mapper.RiparaMapper;
import pwm.penna.salagiochi.form.service.DispositivoDiGiocoService;
import pwm.penna.salagiochi.form.service.RiparaService;
import pwm.penna.salagiochi.model.profilo.Profilo;
import pwm.penna.salagiochi.model.ripara.Ripara;
import pwm.penna.salagiochi.model.tecnico.Tecnico;
import pwm.penna.salagiochi.web.annotation.AmministrazioneMapping;
import pwm.penna.salagiochi.web.base.BaseController;

@Controller
@AmministrazioneMapping
@RequestMapping("/tecnico")
public class TecnicoController extends BaseController {

    @Autowired
    private RiparaMapper riparaMapper;

    @Autowired
    private RiparaService riparaService;

    @Autowired
    private DispositivoDiGiocoService dispositivoDiGiocoService;


    @GetMapping("/ripara")
    public String assegna(Model model, @ModelAttribute("profilo") Profilo profilo) {
        Ripara ripara = new Ripara();
        ripara.setTecnico((Tecnico) profilo.getDipendente());
        return buildForm(model, riparaMapper.toForm(ripara));
    }

    @PostMapping("/ripara")
    public String crea_assegna(Model model, @ModelAttribute("profilo") Profilo profilo, @Valid RiparaForm form, BindingResult bindingResult) {
        form.setTecnico((Tecnico) profilo.getDipendente());

        try {
            if (!bindingResult.hasErrors()) {
                riparaService.crea(form);
                success("action.add.success");
                return "redirect:/admin/tecnico/ripara";
            }
        } catch (Exception e) {
            error(model, "action.add.error");
        }

        return buildForm(model, form);
    }

    private String buildForm(Model model, RiparaForm form) {
        model.addAttribute("riparaForm", form);
        model.addAttribute("dispositivi", dispositivoDiGiocoService.lista());
        return "admin/tecnico/ripara";
    }
}
