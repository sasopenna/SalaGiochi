package pwm.penna.salagiochi.web.advice;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import pwm.penna.salagiochi.model.cassiere.Cassiere;
import pwm.penna.salagiochi.model.dirigente.Dirigente;
import pwm.penna.salagiochi.model.profilo.Profilo;
import pwm.penna.salagiochi.model.tecnico.Tecnico;
import pwm.penna.salagiochi.security.ProfiloUserDetails;

import java.io.File;


@ControllerAdvice
public class ModelControllerAdvice {

    private Profilo currentProfilo() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null && auth.getPrincipal() instanceof ProfiloUserDetails details) {
            return details.getProfilo();
        }
        return null;
    }

    @ModelAttribute("profilo")
    public Profilo profilo() {
        return currentProfilo();
    }

    @ModelAttribute("loggato")
    public boolean loggato() {
        return currentProfilo() != null;
    }

    @ModelAttribute("isSocio")
    public boolean isSocio() {
        Profilo p = currentProfilo();
        return p != null && p.getSocio() != null;
    }

    @ModelAttribute("isDipendente")
    public boolean isDipendente() {
        Profilo p = currentProfilo();
        return p != null && p.getDipendente() != null;
    }

    @ModelAttribute("isTecnico")
    public boolean isTecnico() {
        Profilo p = currentProfilo();
        return p != null && p.getDipendente() instanceof Tecnico;
    }

    @ModelAttribute("isCassiere")
    public boolean isCassiere() {
        Profilo p = currentProfilo();
        return p != null && p.getDipendente() instanceof Cassiere;
    }

    @ModelAttribute("isDirigente")
    public boolean isDirigente() {
        Profilo p = currentProfilo();
        return p != null && p.getDipendente() instanceof Dirigente;
    }

    @ModelAttribute("fotoPath")
    public String fotoPath() {
        Profilo p = currentProfilo();
        String imgPath = "/penna/assets/img/profilo/";
        String imgName = "default";
        String imgExtension = ".jpg";

        if (p != null) {
            String id = p.getEmail();
            File file = new File(imgPath, id + imgExtension);
            if (file.exists()) {
                imgName = id;
            }
        }

        return imgPath + imgName + imgExtension + "?e=" + System.currentTimeMillis();
    }
}
