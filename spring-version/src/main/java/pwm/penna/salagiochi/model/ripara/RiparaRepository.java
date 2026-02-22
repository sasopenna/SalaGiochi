package pwm.penna.salagiochi.model.ripara;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RiparaRepository extends JpaRepository<Ripara, Integer> {
}
