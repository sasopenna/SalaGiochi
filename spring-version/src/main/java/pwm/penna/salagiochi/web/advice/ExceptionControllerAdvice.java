package pwm.penna.salagiochi.web.advice;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.webmvc.error.DefaultErrorAttributes;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@ControllerAdvice
public class ExceptionControllerAdvice {

    private final DefaultErrorAttributes defaultErrorAttributes = new DefaultErrorAttributes();

    @ExceptionHandler(Exception.class)
    public ModelAndView handleException(HttpServletRequest request, Exception ex) {
        request.setAttribute("jakarta.servlet.error.exception", ex);
        request.setAttribute("jakarta.servlet.error.status_code",
                resolveStatusCode(ex));

        WebRequest webRequest = new ServletWebRequest(request);
        Map<String, Object> attrs = defaultErrorAttributes.getErrorAttributes(webRequest,
                ErrorAttributeOptions.of(
                        ErrorAttributeOptions.Include.STATUS,
                        ErrorAttributeOptions.Include.ERROR,
                        ErrorAttributeOptions.Include.EXCEPTION,
                        ErrorAttributeOptions.Include.STACK_TRACE,
                        ErrorAttributeOptions.Include.MESSAGE,
                        ErrorAttributeOptions.Include.BINDING_ERRORS
                )
        );

        ModelAndView mav = new ModelAndView("error");
        mav.addAllObjects(attrs);
        return mav;
    }

    private int resolveStatusCode(Exception ex) {
        ResponseStatus annotation = ex.getClass().getAnnotation(ResponseStatus.class);
        if (annotation != null) return annotation.value().value();
        if (ex instanceof ResponseStatusException rse) return rse.getStatusCode().value();
        return 500;
    }
}