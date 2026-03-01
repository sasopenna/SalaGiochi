package pwm.penna.salagiochi.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import pwm.penna.salagiochi.model.cassiere.Cassiere;
import pwm.penna.salagiochi.model.dirigente.Dirigente;
import pwm.penna.salagiochi.model.profilo.Profilo;
import pwm.penna.salagiochi.model.tecnico.Tecnico;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ProfiloUserDetails implements UserDetails {

    private final Profilo profilo;

    public ProfiloUserDetails(Profilo profilo) {
        this.profilo = profilo;
    }

    public Profilo getProfilo() {
        return profilo;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();

        if (profilo.getSocio() != null) {
            authorities.add(new SimpleGrantedAuthority("ROLE_SOCIO"));
        }

        if (profilo.getDipendente() instanceof Cassiere) {
            authorities.add(new SimpleGrantedAuthority("ROLE_CASSIERE"));
        } else if (profilo.getDipendente() instanceof Tecnico) {
            authorities.add(new SimpleGrantedAuthority("ROLE_TECNICO"));
        } else if (profilo.getDipendente() instanceof Dirigente) {
            authorities.add(new SimpleGrantedAuthority("ROLE_DIRIGENTE"));
        }

        return authorities;
    }

    @Override
    public String getPassword() {
        return profilo.getAccount().getPassword();
    }

    @Override
    public String getUsername() {
        return profilo.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
