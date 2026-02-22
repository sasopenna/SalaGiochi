package pwm.penna.salagiochi.web.controller.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pwm.penna.salagiochi.model.account.Account;
import pwm.penna.salagiochi.model.account.AccountRepository;
import pwm.penna.salagiochi.web.annotation.AccountMapping;
import pwm.penna.salagiochi.web.base.BaseController;

import java.util.Optional;

@Controller
@AccountMapping
public class AccountController extends BaseController {
    @Autowired
    private AccountRepository accountRepository;

    @GetMapping("login")
    public String login() {
        return "account/login";
    }

    @GetMapping("pannello")
    public String pannello(@ModelAttribute("isDipendente") boolean isDipendente) {
        return isDipendente ? "admin/pannello" : "account/pannello";
    }

    @PostMapping("login")
    public String auth(String email, String password) {
        Optional<Account> account = accountRepository.findByEmailAndPassword(email, password);

        if (account.isPresent()) {
            setProfilo(account.get().getProfilo());
            success("action.login_successfull");
            return "redirect:/account/pannello";
        }

        error("action.login_error");
        return "redirect:/account/login";
    }

    @GetMapping("logout")
    public String logout() {
        deleteProfilo();
        success("action.logout_success");
        return "redirect:/";
    }
}
