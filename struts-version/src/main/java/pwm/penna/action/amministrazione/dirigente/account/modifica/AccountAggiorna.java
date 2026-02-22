package pwm.penna.action.amministrazione.dirigente.account.modifica;

import com.opensymphony.xwork2.ActionSupport;

import pwm.penna.pojo.account.Account;
import pwm.penna.pojo.account.AccountDAOFactory;

public class AccountAggiorna extends ActionSupport {
	private static final long serialVersionUID = 1L;
	
	private Account accounts;

	@Override
    public String execute() {
		boolean ok = AccountDAOFactory.getDAO().aggiornaAccount(getAccounts());
		if(ok) {
			addActionMessage(getText("action.mod.success"));
			return SUCCESS;
		} else {
			addActionError(getText("action.mod.error"));
			return INPUT;
		}
	}

	public Account getAccounts() {
		return accounts;
	}

	public void setAccounts(Account accounts) {
		this.accounts = accounts;
	}
}
