package pwm.penna.action.amministrazione.dirigente.dipendenti.cassiere.inserisci;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import pwm.penna.pojo.cassiere.Cassiere;
import pwm.penna.pojo.salagiochi.SalaGiochi;
import pwm.penna.pojo.salagiochi.SalaGiochiDAOFactory;

public class CassiereInserisci extends ActionSupport {
	private static final long serialVersionUID = 1L;
	
	private Cassiere cassiere;
	private List<SalaGiochi> sale;

    @Override
    public String execute() {
    	setSale(SalaGiochiDAOFactory.getDAO().getLista());
    	return SUCCESS;
    }
    
	public Cassiere getCassiere() {
		return cassiere;
	}

	public void setCassiere(Cassiere Cassiere) {
		this.cassiere = Cassiere;
	}

	public List<SalaGiochi> getSale() {
		return sale;
	}

	public void setSale(List<SalaGiochi> sale) {
		this.sale = sale;
	}
}
