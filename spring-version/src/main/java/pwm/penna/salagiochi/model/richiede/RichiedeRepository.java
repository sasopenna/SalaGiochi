package pwm.penna.salagiochi.model.richiede;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pwm.penna.salagiochi.model.cliente.Cliente;

import java.util.List;

@Repository
public interface RichiedeRepository extends JpaRepository<Richiede, Integer> {

    @Query("SELECT COUNT(r) FROM Richiede r WHERE TREAT(r.postazione.dispositivoDiGioco AS DispositivoDiGioco).class = :tipo")
    long countRichiestePerConsole(Class<?> tipo);

    @Query("SELECT r FROM Richiede r WHERE r.cliente = :cliente ORDER BY r.prenotazione DESC")
    List<Richiede> findRichiesteByCliente(Cliente cliente);

    @Query("SELECT r FROM Richiede r WHERE r NOT IN (SELECT a.richiede FROM Assegna a)")
    List<Richiede> findRichiesteNonAssegnate();
}
