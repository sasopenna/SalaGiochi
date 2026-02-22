package pwm.penna.salagiochi.form.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pwm.penna.salagiochi.form.dto.RegistraForm;
import pwm.penna.salagiochi.form.mapper.ProfiloMapper;
import pwm.penna.salagiochi.model.account.Account;
import pwm.penna.salagiochi.model.cliente.Cliente;
import pwm.penna.salagiochi.model.cliente.ClienteRepository;
import pwm.penna.salagiochi.model.profilo.Profilo;
import pwm.penna.salagiochi.model.socio.Socio;
import pwm.penna.salagiochi.model.socio.SocioRepository;

import java.time.LocalDate;

@Service
public class RegistrazioneService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private SocioRepository socioRepository;

    @Autowired
    private ProfiloMapper profiloMapper;

    @Transactional
    public Profilo registraSocio(RegistraForm form) {
        Profilo profilo = profiloMapper.toEntity(form.getProfilo());

        Account account = new Account();
        account.setEmail(form.getProfilo().getEmail());
        account.setPassword(form.getPassword());
        account.setProfilo(profilo);
        profilo.setAccount(account);

        Cliente cliente = clienteRepository.save(new Cliente());

        Socio socio = new Socio();
        socio.setNumeroCliente(cliente.getNumeroCliente());
        socio.setPunteggio(0);
        socio.setMembroDal(LocalDate.now());
        socio.setProfilo(profilo);
        socioRepository.save(socio);

        profilo.setSocio(socio);
        return profilo;
    }
}
