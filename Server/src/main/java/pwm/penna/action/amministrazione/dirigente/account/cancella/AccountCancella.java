package pwm.penna.action.amministrazione.dirigente.account.cancella;

import com.opensymphony.xwork2.ActionSupport;

import pwm.penna.pojo.account.AccountDAOFactory;

public class AccountCancella extends ActionSupport {
	private static final long serialVersionUID = 1L;
	
	private String email;

	@Override
    public String execute() {
		boolean ok = AccountDAOFactory.getDAO().eliminaAccount(getEmail());
		if(ok) {
			addActionMessage(getText("action.del.success"));
		} else {
			addActionError(getText("action.del.error"));
		}
		return SUCCESS;
    }

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
