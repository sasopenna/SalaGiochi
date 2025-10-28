package pwm.penna.action.account.richiedi;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import pwm.penna.pojo.richiede.Richiede;
import pwm.penna.pojo.richiede.RichiedeDAOFactory;
import pwm.penna.pojo.salagiochi.SalaGiochi;
import pwm.penna.pojo.salagiochi.SalaGiochiDAOFactory;
import pwm.penna.utils.interceptors.account.AccountAware;
import pwm.penna.utils.interceptors.account.AccountSession;

public class Richiesta extends ActionSupport implements AccountAware {
	private static final long serialVersionUID = 1L;
	
	private List<SalaGiochi> sale;
	private Richiede richiesta;
	private AccountSession account;

    @Override
    public String execute() {
    	boolean ok = RichiedeDAOFactory.getDAO().creaRichiesta(getRichiesta());
    	if(ok) {
    		this.addActionMessage(getText("action.request_successfull"));
        	return SUCCESS;
    	} else {
    		this.addActionError(getText("action.request_error"));
        	return INPUT;
    	}
    }
    
    @Override
    public void validate() {
    	setSale(SalaGiochiDAOFactory.getDAO().getLista());
    }

	public List<SalaGiochi> getSale() {
		return sale;
	}

	public void setSale(List<SalaGiochi> sale) {
		this.sale = sale;
	}

	public Richiede getRichiesta() {
		return richiesta;
	}

	public void setRichiesta(Richiede richiesta) {
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
