package pwm.penna.salagiochi.web.base;

import org.springframework.ui.Model;

public abstract class BaseController extends FlashMessageHandler {

    protected void success(String message) {
        successMessage(message);
    }

    protected void error(String message) {
        errorMessage(message);
    }

    protected void error(Model model, String message) {
        model.addAttribute(ERROR, message);
        error(message);
    }
}

