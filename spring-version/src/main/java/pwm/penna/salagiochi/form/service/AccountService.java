package pwm.penna.salagiochi.form.service;

import org.springframework.stereotype.Service;
import pwm.penna.salagiochi.form.dto.AccountForm;
import pwm.penna.salagiochi.form.service.base.BaseService;
import pwm.penna.salagiochi.model.account.Account;
import pwm.penna.salagiochi.model.account.AccountRepository;

@Service
public class AccountService extends BaseService<Account, AccountForm, String, AccountRepository> {
}
