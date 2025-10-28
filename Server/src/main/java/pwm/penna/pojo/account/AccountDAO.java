package pwm.penna.pojo.account;

import java.util.List;

public interface AccountDAO {
	public Account getAccount(String a);
	public List<Account> getLista();
	public boolean aggiornaAccount(Account a);
	public boolean eliminaAccount(String email);
}
