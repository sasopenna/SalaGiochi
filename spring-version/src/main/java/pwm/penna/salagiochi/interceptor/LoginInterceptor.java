package pwm.penna.salagiochi.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import pwm.penna.salagiochi.model.profilo.Profilo;
import pwm.penna.salagiochi.web.base.FlashMessageHandler;

@Component
public class LoginInterceptor extends FlashMessageHandler implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String path = request.getServletPath();
        boolean isLoginOrRegister = (path.equals("/account/login") || path.equals("/account/socio/registrazione"));
        Profilo profilo = (Profilo) request.getSession().getAttribute("profilo");

        if (profilo != null && isLoginOrRegister) {
            flashMessage(ERROR, "action.already_loggedin", request, response);
            response.sendRedirect(request.getContextPath() + "/account/pannello");
            return false;
        }

        if (profilo == null && !isLoginOrRegister) {
            flashMessage(ERROR, "action.login.noacc", request, response);
            response.sendRedirect(request.getContextPath() + "/account/login");
            return false;
        }

        return true;
    }
}
