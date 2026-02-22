package pwm.penna.action.amministrazione.dirigente.account.lista;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import pwm.penna.pojo.account.Account;
import pwm.penna.pojo.account.AccountDAOFactory;

public class AccountLista extends ActionSupport {
	private static final long serialVersionUID = 1L;
	
	private List<Account> accounts;

    @Override
    public String execute() {
    	setAccounts(AccountDAOFactory.getDAO().getLista());
    	return SUCCESS;
    }

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}
}
