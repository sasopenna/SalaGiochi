package pwm.penna.salagiochi.web.base;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.FlashMap;
import org.springframework.web.servlet.FlashMapManager;

public class FlashMessageHandler {
    protected final String SUCCESS = "successMessage";
    protected final String ERROR = "errorMessage";

    @Autowired
    private FlashMapManager flashMapManager;
    @Autowired
    private HttpServletRequest httpServletRequest;
    @Autowired
    private HttpServletResponse httpServletResponse;

    private void flashMessage(String key, String value) {
        FlashMap flashMap = new FlashMap();
        flashMap.put(key, value);
        flashMapManager.saveOutputFlashMap(flashMap, httpServletRequest, httpServletResponse);
    }

    protected void successMessage(String message) {
        flashMessage(SUCCESS, message);
    }

    protected void errorMessage(String message) {
        flashMessage(ERROR, message);
    }
}
