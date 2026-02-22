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
import pwm.penna.salagiochi.form.dto.AssegnazioneForm;
import pwm.penna.salagiochi.form.mapper.AssegnaMapper;
import pwm.penna.salagiochi.form.service.AssegnaService;
import pwm.penna.salagiochi.form.service.RichiedeService;
import pwm.penna.salagiochi.model.assegna.Assegna;
import pwm.penna.salagiochi.model.cassiere.Cassiere;
import pwm.penna.salagiochi.model.profilo.Profilo;
import pwm.penna.salagiochi.web.annotation.AmministrazioneMapping;
import pwm.penna.salagiochi.web.base.BaseController;

@Controller
@AmministrazioneMapping
@RequestMapping("/cassiere")
public class CassiereController extends BaseController {

    @Autowired
    private AssegnaMapper assegnaMapper;

    @Autowired
    private AssegnaService assegnaService;

    @Autowired
    private RichiedeService richiedeService;


    @GetMapping("/assegna")
    public String assegna(Model model, @ModelAttribute("profilo") Profilo profilo) {
        Assegna assegna = new Assegna();
        assegna.setCassiere((Cassiere) profilo.getDipendente());
        return buildForm(model, assegnaMapper.toForm(assegna));
    }

    @PostMapping("/assegna")
    public String crea_assegna(Model model, @ModelAttribute("profilo") Profilo profilo, @Valid AssegnazioneForm form, BindingResult bindingResult) {
        form.setCassiere((Cassiere) profilo.getDipendente());

        try {
            if (!bindingResult.hasErrors()) {
                assegnaService.crea(form);
                success("action.add.success");
                return "redirect:/admin/cassiere/assegna";
            }
        } catch (Exception e) {
            error(model, "action.add.error");
        }

        return buildForm(model, form);
    }

    private String buildForm(Model model, AssegnazioneForm form) {
        model.addAttribute("assegnazioneForm", form);
        model.addAttribute("richieste", richiedeService.nonAssegnate());
        return "admin/cassiere/assegna";
    }
}
