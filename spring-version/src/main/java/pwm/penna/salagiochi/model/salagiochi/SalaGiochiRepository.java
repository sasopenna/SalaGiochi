package pwm.penna.salagiochi.model.salagiochi;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalaGiochiRepository extends JpaRepository<SalaGiochi, Integer> {
}
