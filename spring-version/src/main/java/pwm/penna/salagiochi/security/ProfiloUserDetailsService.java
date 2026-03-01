package pwm.penna.salagiochi.security;

import org.jspecify.annotations.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pwm.penna.salagiochi.model.profilo.Profilo;
import pwm.penna.salagiochi.model.profilo.ProfiloRepository;

@Service
public class ProfiloUserDetailsService implements UserDetailsService {

    @Autowired
    private ProfiloRepository profiloRepository;

    @Override
    public UserDetails loadUserByUsername(@NonNull String email) throws UsernameNotFoundException {
        Profilo profilo = profiloRepository.findById(email)
                .orElseThrow(() -> new UsernameNotFoundException("Nessun profilo trovato per: " + email));
        return new ProfiloUserDetails(profilo);
    }
}
