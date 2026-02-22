package pwm.penna.salagiochi.model.dispositivodigioco;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DispositivoDiGiocoRepository extends JpaRepository<DispositivoDiGioco, Integer> {

    @Query("SELECT d FROM DispositivoDiGioco d WHERE d.postazione IS NULL")
    List<DispositivoDiGioco> withoutPostazione();
}
