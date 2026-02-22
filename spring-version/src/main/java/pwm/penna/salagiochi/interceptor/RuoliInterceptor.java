package pwm.penna.salagiochi.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import pwm.penna.salagiochi.model.cassiere.Cassiere;
import pwm.penna.salagiochi.model.dirigente.Dirigente;
import pwm.penna.salagiochi.model.profilo.Profilo;
import pwm.penna.salagiochi.model.tecnico.Tecnico;
import pwm.penna.salagiochi.web.base.FlashMessageHandler;

import java.util.Map;
import java.util.function.Predicate;

@Component
public class RuoliInterceptor extends FlashMessageHandler implements HandlerInterceptor {

    private final Map<String, Predicate<Profilo>> regole = Map.of(
            "/account/socio", p -> p.getSocio() != null,
            "/admin/cassiere", p -> p.getDipendente() instanceof Cassiere,
            "/admin/tecnico", p -> p.getDipendente() instanceof Tecnico,
            "/admin/dirigenza", p -> p.getDipendente() instanceof Dirigente
    );

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Profilo profilo = (Profilo) request.getSession().getAttribute("profilo");
        String path = request.getServletPath();

        for (var entry : regole.entrySet()) {
            if (path.startsWith(entry.getKey())) {
                if (!entry.getValue().test(profilo)) {
                    flashMessage(ERROR, "action.login.noacc", request, response);
                    response.sendRedirect(request.getContextPath());
                    return false;
                }
            }
        }

        return true;
    }
}