package pwm.penna.salagiochi.web.controller.account;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import pwm.penna.salagiochi.web.annotation.AccountMapping;
import pwm.penna.salagiochi.web.base.BaseController;

@Controller
@AccountMapping
public class AccountController extends BaseController {

    @GetMapping("login")
    public String login() {
        return "account/login";
    }

    @GetMapping("pannello")
    public String pannello(@ModelAttribute("isDipendente") boolean isDipendente) {
        return isDipendente ? "admin/pannello" : "account/pannello";
    }
}
