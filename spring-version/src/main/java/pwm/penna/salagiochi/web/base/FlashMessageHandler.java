package pwm.penna.salagiochi.web.base;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.FlashMap;
import org.springframework.web.servlet.FlashMapManager;
import org.springframework.web.servlet.support.RequestContextUtils;

public class FlashMessageHandler {
    protected final String SUCCESS = "successMessage";
    protected final String ERROR = "errorMessage";

    protected void flashMessage(String key, String value, HttpServletRequest request) {
        FlashMap flashMap = RequestContextUtils.getOutputFlashMap(request);
        flashMap.put(key, value);
    }

    protected void flashMessage(String key, String value, HttpServletRequest request, HttpServletResponse response) {
        FlashMap flashMap = new FlashMap();
        flashMap.put(key, value);

        FlashMapManager flashMapManager = RequestContextUtils.getFlashMapManager(request);
        flashMapManager.saveOutputFlashMap(flashMap, request, response);
    }
}
