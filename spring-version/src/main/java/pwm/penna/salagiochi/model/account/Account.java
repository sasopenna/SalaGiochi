package pwm.penna.salagiochi.model.account;

import jakarta.persistence.*;
import pwm.penna.salagiochi.model.profilo.Profilo;

import java.time.LocalDate;

@Entity
@Table(name = "account")
public class Account {

    @Id
    @Column(name = "Email", length = 100)
    private String email;

    @Column(name = "Password", length = 100)
    private String password;

    @Column(name = "UltimoLogin")
    private LocalDate ultimoLogin;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @PrimaryKeyJoinColumn
    private Profilo profilo;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getUltimoLogin() {
        return ultimoLogin;
    }

    public void setUltimoLogin(LocalDate ultimoLogin) {
        this.ultimoLogin = ultimoLogin;
    }

    public Profilo getProfilo() {
        return profilo;
    }

    public void setProfilo(Profilo profilo) {
        this.profilo = profilo;
    }
}
