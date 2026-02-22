package pwm.penna.salagiochi.web.controller.admin.dirigenza;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import pwm.penna.salagiochi.form.dto.AccountForm;
import pwm.penna.salagiochi.form.service.AccountService;
import pwm.penna.salagiochi.web.annotation.DirigenzaMapping;
import pwm.penna.salagiochi.web.controller.admin.dirigenza.base.BaseDirigenzaController;

@Controller
@DirigenzaMapping
@RequestMapping("/account")
public class AccountDirigenzaController extends BaseDirigenzaController<AccountForm, String, AccountService> {

    @Override
    protected String getBasePath() {
        return "account";
    }
}
