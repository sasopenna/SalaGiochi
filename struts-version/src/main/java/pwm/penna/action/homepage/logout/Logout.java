package pwm.penna.action.homepage.logout;

import java.util.Map;

import org.apache.struts2.action.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import pwm.penna.utils.interceptors.account.AccountSession;

public class Logout extends ActionSupport implements SessionAware {
	private static final long serialVersionUID = 1L;
	
	private Map<String, Object> session;

	@Override
	public String execute() {
		AccountSession account = (AccountSession) session.get(AccountSession.SESSION_ID);
		if(account == null) {
			this.addActionError(getText("action.logout_err"));
		} else {
			session.remove(AccountSession.SESSION_ID);
			this.addActionMessage(getText("action.logout_success"));
		}
		return SUCCESS;
	}

	@Override
	public void withSession(Map<String, Object> session) {
		this.session = session;
	}
}
