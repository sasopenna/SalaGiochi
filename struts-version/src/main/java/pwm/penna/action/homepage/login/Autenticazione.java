package pwm.penna.action.homepage.login;

import java.util.Map;

import org.apache.struts2.action.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import pwm.penna.utils.interceptors.account.AccountSession;

public class Autenticazione extends ActionSupport implements SessionAware {
	private static final long serialVersionUID = 1L;

	private Map<String, Object> session;
	private String email;
	private String password;
	private boolean fromRegistration = false;

	@Override
	public String execute() {
		AccountSession account = AccountSession.checkCredentials(email, password);
		
		if(account == null) {
			this.addActionError(getText("action.login_error"));
			return INPUT;
		} else {
			session.put(AccountSession.SESSION_ID, account);
			
			if(isFromRegistration()) {
				this.addActionMessage(getText("action.register_successfull"));
				return SUCCESS;
			} else {
				this.addActionMessage(getText("action.login_successfull"));
				if(account.getAccount().getProfilo().getSocio() != null) {
					return "user";
				} else {
					return "admin";
				}
			}
		}
	}

	@Override
	public void withSession(Map<String, Object> session) {
		this.session = session;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isFromRegistration() {
		return fromRegistration;
	}

	public void setFromRegistration(boolean fromRegistration) {
		this.fromRegistration = fromRegistration;
	}
}
