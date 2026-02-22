package pwm.penna.salagiochi.model.socio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SocioRepository extends JpaRepository<Socio, Integer> {

    @Query("SELECT COUNT(s) FROM Socio s WHERE s.profilo.sesso = :sesso")
    long countBySesso(String sesso);

    @Query("SELECT s FROM Socio s ORDER BY s.punteggio DESC LIMIT 5")
    List<Socio> findTop5ByPunteggio();

    @Query("SELECT s FROM Socio s ORDER BY s.membroDal ASC LIMIT 5")
    List<Socio> findTop5ByMembroDal();
}
