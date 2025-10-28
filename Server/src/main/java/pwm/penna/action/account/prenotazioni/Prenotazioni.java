package pwm.penna.action.account.prenotazioni;

import java.util.Set;

import com.opensymphony.xwork2.ActionSupport;

import pwm.penna.pojo.cliente.Cliente;
import pwm.penna.pojo.cliente.ClienteDAOFactory;
import pwm.penna.pojo.richiede.Richiede;
import pwm.penna.utils.interceptors.account.AccountAware;
import pwm.penna.utils.interceptors.account.AccountSession;

public class Prenotazioni extends ActionSupport implements AccountAware {
	private static final long serialVersionUID = 1L;

	private Set<Richiede> richieste;
	private AccountSession account;
	
    @Override
    public String execute() {
    	Cliente c = account.getAccount().getProfilo().getSocio().getCliente();
    	ClienteDAOFactory.getDAO().loadRichieste(c);
    	setRichieste(c.getRichieste());
    	return SUCCESS;
    }

	public Set<Richiede> getRichieste() {
		return richieste;
	}

	public void setRichieste(Set<Richiede> richieste) {
		this.richieste = richieste;
	}

	@Override
	public void setAccount(AccountSession account) {
		this.account = account;
	}
}