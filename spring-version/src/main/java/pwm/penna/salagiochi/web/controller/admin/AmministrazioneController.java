package pwm.penna.salagiochi.web.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pwm.penna.salagiochi.web.annotation.AmministrazioneMapping;

@Controller
@AmministrazioneMapping
public class AmministrazioneController {
    @RequestMapping
    public String def() {
        return pannello();
    }

    @GetMapping("pannello")
    public String pannello() {
        return "redirect:/account/pannello";
    }
}
