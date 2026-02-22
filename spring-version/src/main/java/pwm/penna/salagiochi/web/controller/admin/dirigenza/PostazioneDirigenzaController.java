package pwm.penna.salagiochi.web.controller.admin.dirigenza;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pwm.penna.salagiochi.form.dto.PostazioneForm;
import pwm.penna.salagiochi.form.service.DispositivoDiGiocoService;
import pwm.penna.salagiochi.form.service.PostazioneService;
import pwm.penna.salagiochi.form.service.SalaGiochiService;
import pwm.penna.salagiochi.model.dispositivodigioco.DispositivoDiGioco;
import pwm.penna.salagiochi.model.postazione.PostazioneId;
import pwm.penna.salagiochi.web.annotation.DirigenzaMapping;
import pwm.penna.salagiochi.web.controller.admin.dirigenza.base.BaseDirigenzaController;

import java.util.List;

@Controller
@DirigenzaMapping
@RequestMapping("/postazione")
public class PostazioneDirigenzaController extends BaseDirigenzaController<PostazioneForm, PostazioneId, PostazioneService> {

    @Autowired
    private SalaGiochiService salaGiochiService;
    @Autowired
    private DispositivoDiGiocoService dispositivoDiGiocoService;

    @Override
    protected String getBasePath() {
        return "postazione";
    }

    @Override
    protected void buildModel(Model model, PostazioneId id) {
        model.addAttribute("sale", salaGiochiService.lista());

        DispositivoDiGioco dispositivoDiGioco = getService().findById(id).getDispositivoDiGioco();
        List<DispositivoDiGioco> dispositivi = dispositivoDiGiocoService.withoutPostazione();
        dispositivi.add(0, dispositivoDiGioco);
        model.addAttribute("dispositivi", dispositivi);
    }
}
