package pwm.penna.utils.interceptors;

import java.util.Map;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.Interceptor;

import pwm.penna.utils.interceptors.account.AccountAware;
import pwm.penna.utils.interceptors.account.AccountSession;

public class AuthenticationInterceptor implements Interceptor {
	private static final long serialVersionUID = 1L;

	public void init() { }
	public void destroy() { }

	public String intercept(ActionInvocation actionInvocation) throws Exception {
		Map<String, Object> session = actionInvocation.getInvocationContext().getSession();

		AccountSession account = (AccountSession) session.get(AccountSession.SESSION_ID);

		ActionSupport action = (ActionSupport) actionInvocation.getAction();
		
		if (account != null && action instanceof AccountAware) {
			((AccountAware) action).setAccount(account);
		}
		
		return actionInvocation.invoke();
	}
}
