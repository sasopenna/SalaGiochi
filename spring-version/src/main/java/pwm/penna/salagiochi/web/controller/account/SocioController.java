package pwm.penna.salagiochi.web.controller.account;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pwm.penna.salagiochi.form.dto.RegistraForm;
import pwm.penna.salagiochi.form.dto.RichiedeForm;
import pwm.penna.salagiochi.form.mapper.RichiedeMapper;
import pwm.penna.salagiochi.form.service.RegistrazioneService;
import pwm.penna.salagiochi.form.service.RichiedeService;
import pwm.penna.salagiochi.form.service.SalaGiochiService;
import pwm.penna.salagiochi.model.profilo.Profilo;
import pwm.penna.salagiochi.model.richiede.Richiede;
import pwm.penna.salagiochi.web.annotation.AccountMapping;
import pwm.penna.salagiochi.web.base.BaseController;

@Controller
@AccountMapping
@RequestMapping("/socio")
public class SocioController extends BaseController {
    @Autowired
    private RichiedeMapper richiedeMapper;
    @Autowired
    private RichiedeService richiedeService;
    @Autowired
    private RegistrazioneService registrazioneService;
    @Autowired
    private SalaGiochiService salaGiochiService;

    @RequestMapping
    public String def() {
        return "account/socio/profilo";
    }

    @GetMapping("registrazione")
    public String registrazione(Model model) {
        model.addAttribute("registraForm", new RegistraForm());
        return "account/socio/registrazione";
    }

    @PostMapping("registrazione")
    public String registra(@Valid RegistraForm registraForm, BindingResult bindingResult) {

        if (!registraForm.getPassword().equals(registraForm.getConfirmPassword())) {
            bindingResult.rejectValue("confirmPassword", "validator.password_diff");
        }

        try {
            if (!bindingResult.hasErrors()) {
                registrazioneService.registraSocio(registraForm);
                success("action.register_successfull");
                return "redirect:/account/login";
            }
        } catch (Exception e) {
            error("action.register_error");
        }
        return "account/socio/registrazione";
    }

    @GetMapping("prenotazioni")
    public String prenotazioni(Model model, @ModelAttribute("profilo") Profilo profilo) {
        model.addAttribute("richieste", richiedeService.byCliente(profilo.getSocio().getCliente()));
        return "account/socio/prenotazioni";
    }

    @GetMapping("richiedi")
    public String richiedi(Model model, @ModelAttribute("profilo") Profilo profilo) {
        Richiede richiede = new Richiede();
        richiede.setCliente(profilo.getSocio().getCliente());
        return buildForm(model, richiedeMapper.toForm(richiede));
    }

    @PostMapping("richiedi")
    public String richiesta(Model model, @ModelAttribute("profilo") Profilo profilo, @Valid RichiedeForm form, BindingResult bindingResult) {
        form.setCliente(profilo.getSocio().getCliente());

        try {
            if (!bindingResult.hasErrors()) {
                richiedeService.crea(form);
                success("action.request_successfull");
                return "redirect:/account/socio/prenotazioni";
            }
        } catch (Exception e) {
            error(model, "action.request_error");
        }
        return buildForm(model, form);
    }

    private String buildForm(Model model, RichiedeForm form) {
        model.addAttribute("richiedeForm", form);
        model.addAttribute("sale", salaGiochiService.lista());
        return "account/socio/richiedi";
    }
}
