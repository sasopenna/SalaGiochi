package pwm.penna.action.homepage.login;

import com.opensymphony.xwork2.ActionSupport;

import pwm.penna.utils.interceptors.account.AccountAware;
import pwm.penna.utils.interceptors.account.AccountSession;

public class Login extends ActionSupport implements AccountAware {
	private static final long serialVersionUID = 1L;

	private AccountSession account;
	
    @Override
    public String execute() {
    	if(account == null) return SUCCESS;
    	// se non è loggato
		this.addActionError(getText("action.already_loggedin"));
		return ERROR;
    }

	@Override
	public void setAccount(AccountSession account) {
		this.account = account;
	}
}
