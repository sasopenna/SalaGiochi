package pwm.penna.salagiochi.model.account;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, String> {
    @Query("SELECT a FROM Account a WHERE a.email = :email AND a.password = :password")
    Optional<Account> findByEmailAndPassword(String email, String password);
}
