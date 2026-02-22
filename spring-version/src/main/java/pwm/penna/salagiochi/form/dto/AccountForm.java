package pwm.penna.salagiochi.form.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import pwm.penna.salagiochi.form.annotation.ValidPassword;
import pwm.penna.salagiochi.form.dto.base.BaseForm;

public class AccountForm extends BaseForm<String> {

    private Integer id;

    @NotBlank(message = "{validator.required}")
    @Email(message = "{validator.email}")
    private String email;

    @NotBlank(message = "{validator.required}")
    @ValidPassword
    private String password;

    // getters & setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    @Override
    public String getKey() {
        return getEmail();
    }

    @Override
    public void setKey(String key) {
        setEmail(key);
    }
}
