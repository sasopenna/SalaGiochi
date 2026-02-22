package pwm.penna.salagiochi.web.controller.api;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pwm.penna.salagiochi.form.service.PostazioneService;
import pwm.penna.salagiochi.form.service.StatsService;
import pwm.penna.salagiochi.model.postazione.Postazione;
import pwm.penna.salagiochi.model.salagiochi.SalaGiochi;
import pwm.penna.salagiochi.model.socio.Socio;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/API")
public class ApiController {
    @Autowired
    PostazioneService postazioneService;

    @JsonView(ApiView.Postazione.class)
    @GetMapping("cercaPostazione/{sala}/{piattaforma}")
    public Map<String, List<Postazione>> cercaPostazione(@PathVariable String sala, @PathVariable String piattaforma) {
        return Map.of("result", postazioneService.cercaPostazioni(sala, piattaforma));
    }

    // I mapping sotto li ho dovuti mettere tutti in uppercase per renderlo "retrocompatibile" con l'app Android
    @Autowired
    StatsService statsService;

    @GetMapping("Home")
    public Map<String, Object> home() {
        return statsService.home();
    }

    @GetMapping("Statistiche")
    public Map<String, Object> stats() {
        return statsService.stats();
    }

    @GetMapping("SaleGiochi")
    public Map<String, List<SalaGiochi>> sale() {
        return Map.of("sale", statsService.sale());
    }

    @GetMapping("Soci")
    public Map<String, List<Socio>> soci() {
        return Map.of("soci", statsService.soci());
    }

    @GetMapping("Dipendenti")
    public Map<String, List<?>> dipendenti(@RequestParam String q) {
        return Map.of("dipendenti", statsService.dipendenti(q));
    }
}
