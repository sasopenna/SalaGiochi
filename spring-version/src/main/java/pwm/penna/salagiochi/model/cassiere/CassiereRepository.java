package pwm.penna.salagiochi.model.cassiere;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CassiereRepository extends JpaRepository<Cassiere, Integer> {
}
