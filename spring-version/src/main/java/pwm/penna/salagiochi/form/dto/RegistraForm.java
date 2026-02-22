package pwm.penna.salagiochi.form.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import pwm.penna.salagiochi.form.annotation.ValidPassword;

public class RegistraForm {

    @Valid
    private ProfiloForm profilo = new ProfiloForm();

    @NotBlank(message = "{validator.required}")
    @ValidPassword
    private String password;

    @NotBlank(message = "{validator.required}")
    @ValidPassword
    private String confirmPassword;

    public ProfiloForm getProfilo() {
        return profilo;
    }

    public void setProfilo(ProfiloForm profilo) {
        this.profilo = profilo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
