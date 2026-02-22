package pwm.penna.action.amministrazione.dirigente.account.modifica;

import com.opensymphony.xwork2.ActionSupport;

import pwm.penna.pojo.account.Account;
import pwm.penna.pojo.account.AccountDAOFactory;

public class AccountModifica extends ActionSupport {
	private static final long serialVersionUID = 1L;

	private Account accounts;
 	private String email;

    @Override
    public String execute() {
    	setAccounts(AccountDAOFactory.getDAO().getAccount(getEmail()));
    	return INPUT;
    }

	public Account getAccounts() {
		return accounts;
	}

	public void setAccounts(Account accounts) {
		this.accounts = accounts;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
