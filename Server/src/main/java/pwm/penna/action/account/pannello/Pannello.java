package pwm.penna.action.account.pannello;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

import pwm.penna.utils.interceptors.account.AccountAware;
import pwm.penna.utils.interceptors.account.AccountSession;

public class Pannello extends ActionSupport implements AccountAware, Action {
	private static final long serialVersionUID = 1L;
	
	private AccountSession account;

    @Override
    public String execute() {
    	return SUCCESS;
    }
    
    public AccountSession getAccount() {
    	return this.account;
    }

	@Override
	public void setAccount(AccountSession account) {
		this.account = account;
	}
}
