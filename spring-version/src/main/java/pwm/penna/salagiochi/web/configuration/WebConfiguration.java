package pwm.penna.salagiochi.web.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import pwm.penna.salagiochi.form.converter.StringToPostazioneIdConverter;
import pwm.penna.salagiochi.web.annotation.AccountMapping;
import pwm.penna.salagiochi.web.annotation.AmministrazioneMapping;
import pwm.penna.salagiochi.web.annotation.DirigenzaMapping;

@Configuration
public class WebConfiguration implements WebMvcConfigurer {
    @Autowired
    private StringToPostazioneIdConverter postazioneIdConverter;

    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        configurer.addPathPrefix("/account", c -> c.isAnnotationPresent(AccountMapping.class));
        configurer.addPathPrefix("/admin", c -> c.isAnnotationPresent(AmministrazioneMapping.class));
        configurer.addPathPrefix("/admin/dirigenza", c -> c.isAnnotationPresent(DirigenzaMapping.class));
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(postazioneIdConverter);
    }
}
