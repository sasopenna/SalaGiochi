package pwm.penna.salagiochi.model.dirigente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DirigenteRepository extends JpaRepository<Dirigente, Integer> {
}
