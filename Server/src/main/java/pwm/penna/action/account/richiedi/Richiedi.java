package pwm.penna.action.account.richiedi;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import pwm.penna.pojo.salagiochi.SalaGiochi;
import pwm.penna.pojo.salagiochi.SalaGiochiDAOFactory;
import pwm.penna.utils.interceptors.account.AccountAware;
import pwm.penna.utils.interceptors.account.AccountSession;

public class Richiedi extends ActionSupport implements AccountAware {
	private static final long serialVersionUID = 1L;
	
	private List<SalaGiochi> sale;
	private Richiedi richiesta;
	private AccountSession account;

    @Override
    public String execute() {
    	setSale(SalaGiochiDAOFactory.getDAO().getLista());
    	return SUCCESS;
    }

	public List<SalaGiochi> getSale() {
		return sale;
	}

	public void setSale(List<SalaGiochi> sale) {
		this.sale = sale;
	}

	public Richiedi getRichiesta() {
		return richiesta;
	}

	public void setRichiesta(Richiedi richiesta) {
		this.richiesta = richiesta;
	}

	public AccountSession getAccount() {
		return account;
	}
	
	@Override
	public void setAccount(AccountSession account) {
		this.account = account;
	}
}
