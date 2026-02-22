package pwm.penna.salagiochi.web.base;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import pwm.penna.salagiochi.model.profilo.Profilo;
import pwm.penna.salagiochi.web.advice.ModelControllerAdvice;

public abstract class BaseController extends FlashMessageHandler {

    @Autowired
    protected HttpServletRequest request;

    protected void success(String message) {
        flashMessage(SUCCESS, message, request);
    }

    protected void error(String message) {
        flashMessage(ERROR, message, request);
    }

    protected void error(Model model, String message) {
        model.addAttribute(ERROR, message);
        error(message);
    }

    protected void setProfilo(Profilo profilo) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.setAttribute(ModelControllerAdvice.PROFILE, profilo);
        }
    }

    protected void deleteProfilo() {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.removeAttribute(ModelControllerAdvice.PROFILE);
        }
    }
}

