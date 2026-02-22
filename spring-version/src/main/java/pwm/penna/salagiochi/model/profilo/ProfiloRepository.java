package pwm.penna.salagiochi.model.profilo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfiloRepository extends JpaRepository<Profilo, String> {
}
