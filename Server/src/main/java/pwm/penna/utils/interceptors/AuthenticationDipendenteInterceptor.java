package pwm.penna.utils.interceptors;

import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.Interceptor;

import pwm.penna.utils.interceptors.account.AccountSession;

public class AuthenticationDipendenteInterceptor implements Interceptor {
	private static final long serialVersionUID = 1L;

	public void init() { }
	public void destroy() { }

	public String intercept(ActionInvocation actionInvocation) throws Exception {
		Map<String, Object> session = actionInvocation.getInvocationContext().getSession();

		AccountSession account = (AccountSession) session.get(AccountSession.SESSION_ID);

		ActionSupport action = (ActionSupport) actionInvocation.getAction();
		
		if (account == null) {
			action.addActionError(action.getText("action.login.noacc"));
			return Action.LOGIN;
		}
		
		if (account.getAccount().getProfilo().getDipendente() == null) {
			action.addActionError(action.getText("action.login.noadmin"));
			return Action.ERROR;
		}

		return actionInvocation.invoke();
	}
}
