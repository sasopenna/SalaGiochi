package pwm.penna.utils.interceptors;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.PreResultListener;
import com.opensymphony.xwork2.interceptor.ValidationAware;

@SuppressWarnings("unchecked")
public class CustomMessageStorePreResultListener implements PreResultListener {
	public static final String fieldErrorsSessionKey = "__CustomMessageStoreInterceptor_FieldErrors_SessionKey";
	public static final String actionErrorsSessionKey = "__CustomMessageStoreInterceptor_ActionErrors_SessionKey";
	public static final String actionMessagesSessionKey = "__CustomMessageStoreInterceptor_ActionMessages_SessionKey";

    @Override
    public void beforeResult(ActionInvocation invocation, String resultCode) {
        Map<String, Object> session = invocation.getInvocationContext().getSession();
        if (session == null) return;

        ValidationAware validationAwareAction = null;
        Object action = invocation.getAction();
        if (action instanceof ValidationAware) {
            validationAwareAction = (ValidationAware) action;
        }
        if(validationAwareAction == null) return;
        
        // action errors (rossi)
        Collection<String> sessionActionErrors = (Collection<String>) session.get(actionErrorsSessionKey);
        Collection<String> validationActionErrors = validationAwareAction.getActionErrors();

        if (sessionActionErrors != null && sessionActionErrors.size() > 0) {
            session.remove(actionErrorsSessionKey);
            validationAwareAction.setActionErrors(sessionActionErrors);
        }

        if (validationActionErrors != null && validationActionErrors.size() > 0) {
            session.put(actionErrorsSessionKey, validationActionErrors);
        }

        // action messages (verdi)
        Collection<String> sessionActionMessages = (Collection<String>) session.get(actionMessagesSessionKey);
        Collection<String> validationActionMessages = validationAwareAction.getActionMessages();

        if (sessionActionMessages != null && sessionActionMessages.size() > 0) {
            session.remove(actionMessagesSessionKey);
            validationAwareAction.setActionMessages(sessionActionMessages);
        }

        if (validationActionMessages != null && validationActionMessages.size() > 0) {
            session.put(actionMessagesSessionKey, validationActionMessages);
        }

        // field errors (i campi)
        Map<String, List<String>> sessionFieldErrors = (Map<String, List<String>>) session.get(fieldErrorsSessionKey);
        Map<String, List<String>> validationFieldErrors = validationAwareAction.getFieldErrors();

        if (sessionFieldErrors != null && sessionFieldErrors.size() > 0) {
            session.remove(fieldErrorsSessionKey);
            validationAwareAction.setFieldErrors(sessionFieldErrors);
        }

        if (validationFieldErrors != null && validationFieldErrors.size() > 0) {
            session.put(fieldErrorsSessionKey, validationFieldErrors);
        }
    }
}
