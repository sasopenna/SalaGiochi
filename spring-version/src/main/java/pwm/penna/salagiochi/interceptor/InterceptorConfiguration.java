package pwm.penna.salagiochi.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfiguration implements WebMvcConfigurer {
    @Autowired
    private LoginInterceptor loginInterceptor;
    @Autowired
    private RuoliInterceptor ruoliInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // Se non è loggato può solo vedere "/account/login"
        registry.addInterceptor(loginInterceptor)
                .addPathPatterns(
                        "/account/**",
                        "/admin/**"
                );

        // Interceptor che differienza i ruoli
        registry.addInterceptor(ruoliInterceptor)
                .addPathPatterns(
                        "/account/socio/**",
                        "/admin/cassiere/**",
                        "/admin/tecnico/**",
                        "/admin/dirigenza/**"
                )
                .excludePathPatterns("/account/socio/registrazione");
    }
}
