package pwm.penna.salagiochi.form.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pwm.penna.salagiochi.model.cassiere.CassiereRepository;
import pwm.penna.salagiochi.model.dipendente.DipendenteRepository;
import pwm.penna.salagiochi.model.dirigente.DirigenteRepository;
import pwm.penna.salagiochi.model.dispositivodigioco.DispositivoDiGiocoRepository;
import pwm.penna.salagiochi.model.dispositivodigioco.tipo.PC;
import pwm.penna.salagiochi.model.dispositivodigioco.tipo.PlayStation;
import pwm.penna.salagiochi.model.dispositivodigioco.tipo.Xbox;
import pwm.penna.salagiochi.model.salagiochi.SalaGiochi;
import pwm.penna.salagiochi.model.salagiochi.SalaGiochiRepository;
import pwm.penna.salagiochi.model.socio.Socio;
import pwm.penna.salagiochi.model.socio.SocioRepository;
import pwm.penna.salagiochi.model.tecnico.TecnicoRepository;

import java.util.List;
import java.util.Map;

@Service
public class StatsService {
    @Autowired
    private SalaGiochiRepository salaGiochiRepository;
    @Autowired
    private SocioRepository socioRepository;
    @Autowired
    private DispositivoDiGiocoRepository dispositivoDiGiocoRepository;
    @Autowired
    private DipendenteRepository dipendenteRepository;
    @Autowired
    private CassiereRepository cassiereRepository;
    @Autowired
    private TecnicoRepository tecnicoRepository;
    @Autowired
    private DirigenteRepository dirigenteRepository;
    @Autowired
    private RichiedeService richiedeService;

    public Map<String, Object> home() {
        return Map.of(
                "sale", salaGiochiRepository.count(),
                "soci", socioRepository.count(),
                "ddg", dispositivoDiGiocoRepository.count(),
                "dipendenti", dipendenteRepository.count(),
                "cassieri", cassiereRepository.count(),
                "tecnici", tecnicoRepository.count(),
                "dirigenti", dirigenteRepository.count()
        );
    }

    public Map<String, Object> stats() {
        return Map.of(
                "uomo", socioRepository.countBySesso("Uomo"),
                "donna", socioRepository.countBySesso("Donna"),
                "top5", socioRepository.findTop5ByPunteggio(),
                "fedeli5", socioRepository.findTop5ByMembroDal(),
                "pc", richiedeService.countByConsole(PC.class),
                "xbox", richiedeService.countByConsole(Xbox.class),
                "play", richiedeService.countByConsole(PlayStation.class)
        );
    }

    public List<SalaGiochi> sale() {
        return salaGiochiRepository.findAll();
    }

    public List<Socio> soci() {
        return socioRepository.findAll();
    }

    public List<?> dipendenti(String q) {
        return switch (q.toLowerCase()) {
            case "dirigenti" -> dirigenteRepository.findAll();
            case "cassieri" -> cassiereRepository.findAll();
            case "tecnici" -> tecnicoRepository.findAll();
            default -> List.of();
        };
    }
}
