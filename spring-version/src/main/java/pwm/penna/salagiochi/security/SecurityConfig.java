package pwm.penna.salagiochi.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import pwm.penna.salagiochi.web.base.FlashMessageHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends FlashMessageHandler {

    // Uso NoOp poichè precedentemente le ho salvate in chiaro
    @Bean
    @SuppressWarnings("deprecation")
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) {
        return http
                .authorizeHttpRequests(auth -> auth
                        // Permetto i path di login e registrazione solo se non sono autenticati (anonimi)
                        .requestMatchers("/account/login", "/account/socio/registrazione").anonymous()
                        // Definisco i ruoli e i rispettivi path
                        .requestMatchers("/account/socio/**").hasRole("SOCIO")
                        .requestMatchers("/admin/cassiere/**").hasRole("CASSIERE")
                        .requestMatchers("/admin/tecnico/**").hasRole("TECNICO")
                        .requestMatchers("/admin/dirigenza/**").hasRole("DIRIGENTE")
                        // Impongo che per questi path bisogna essere autenticati
                        .requestMatchers("/account/**", "/admin/**").authenticated()
                        // Tutto il resto lo rendo pubblico
                        .anyRequest().permitAll()
                )
                // Definisco il path di login
                .formLogin(form -> form
                        .loginPage("/account/login") // GET url
                        .loginProcessingUrl("/account/login") // POST url
                        .usernameParameter("email") // parametro di user nel form
                        .passwordParameter("password") //paramentro di pass nel form
                        // Handler per autenticazione esatta
                        .successHandler((request, response, authentication) -> {
                            successMessage("action.login_successfull");
                            response.sendRedirect(request.getContextPath() + "/account/pannello");
                        })
                        // Handler per autenticazione errata
                        .failureHandler((request, response, exception) -> {
                            errorMessage("action.login_error");
                            response.sendRedirect(request.getContextPath() + "/account/login");
                        })
                        // Permetto tutto il resto
                        .permitAll()
                )
                // Definisco il path di logout
                .logout(logout -> logout
                        .logoutUrl("/account/logout")
                        // Handler per logout
                        .logoutSuccessHandler((request, response, authentication) -> {
                            successMessage("action.logout_success");
                            response.sendRedirect(request.getContextPath() + "/");
                        })
                        // Cancello la sessione
                        .invalidateHttpSession(true)
                        .deleteCookies("JSESSIONID")
                        // Permetto tutto il resto
                        .permitAll()
                )
                // Fallback quando non si cerca di entrare in una pagina da non autenticati
                .exceptionHandling(ex -> ex
                        .accessDeniedHandler((request, response, accessDeniedException) -> {
                            errorMessage("action.login.noacc");
                            response.sendRedirect(request.getContextPath() + "/");
                        })
                )
                // Build del chain
                .build();
    }
}
