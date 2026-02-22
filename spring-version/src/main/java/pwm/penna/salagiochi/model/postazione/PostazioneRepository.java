package pwm.penna.salagiochi.model.postazione;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostazioneRepository extends JpaRepository<Postazione, PostazioneId> {

    @Query("SELECT p FROM Postazione p WHERE p.id.salaGiochi.codice = :codice AND TYPE(p.dispositivoDiGioco) = :tipo")
    List<Postazione> findBySalaAndTipo(String codice, Class<?> tipo);
}
