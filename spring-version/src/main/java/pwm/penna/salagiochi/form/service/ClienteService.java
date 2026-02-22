package pwm.penna.salagiochi.form.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pwm.penna.salagiochi.model.cliente.Cliente;
import pwm.penna.salagiochi.model.cliente.ClienteRepository;

import java.util.List;

// Non implementato come base service
@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> lista() {
        return clienteRepository.findAll();
    }

    public List<Cliente> notSoci() {
        return clienteRepository.notSoci();
    }
}