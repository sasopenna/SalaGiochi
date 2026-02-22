package pwm.penna.salagiochi.model.assegna;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssegnaRepository extends JpaRepository<Assegna, Integer> {
}
