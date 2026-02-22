package pwm.penna.salagiochi.web.advice;

import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import pwm.penna.salagiochi.model.cassiere.Cassiere;
import pwm.penna.salagiochi.model.dirigente.Dirigente;
import pwm.penna.salagiochi.model.profilo.Profilo;
import pwm.penna.salagiochi.model.tecnico.Tecnico;

import java.io.File;

@ControllerAdvice
public class ModelControllerAdvice {
    public static final String PROFILE = "profilo";

    @ModelAttribute("profilo")
    public Profilo profilo(HttpSession session) {
        return (Profilo) session.getAttribute(PROFILE);
    }

    @ModelAttribute("loggato")
    public boolean loggato(@ModelAttribute("profilo") Profilo p) {
        return p != null;
    }

    @ModelAttribute("isSocio")
    public boolean isSocio(@ModelAttribute("profilo") Profilo p) {
        return p != null && p.getSocio() != null;
    }

    @ModelAttribute("isDipendente")
    public boolean isDipendente(@ModelAttribute("profilo") Profilo p) {
        return p != null && p.getDipendente() != null;
    }

    @ModelAttribute("isTecnico")
    public boolean isTecnico(@ModelAttribute("profilo") Profilo p) {
        return p != null && p.getDipendente() instanceof Tecnico;
    }

    @ModelAttribute("isCassiere")
    public boolean isCassiere(@ModelAttribute("profilo") Profilo p) {
        return p != null && p.getDipendente() instanceof Cassiere;
    }

    @ModelAttribute("isDirigente")
    public boolean isDirigente(@ModelAttribute("profilo") Profilo p) {
        return p != null && p.getDipendente() instanceof Dirigente;
    }

    @ModelAttribute("fotoPath")
    public String fotoPath(@ModelAttribute("profilo") Profilo p) {
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