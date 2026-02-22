package pwm.penna.action.amministrazione.dirigente.dipendenti.cassiere.inserisci;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import pwm.penna.pojo.cassiere.Cassiere;
import pwm.penna.pojo.cassiere.CassiereDAOFactory;
import pwm.penna.pojo.salagiochi.SalaGiochi;
import pwm.penna.pojo.salagiochi.SalaGiochiDAOFactory;

public class CassiereCrea extends ActionSupport {
	private static final long serialVersionUID = 1L;

	private Cassiere cassiere;
	private List<SalaGiochi> sale;

	@Override
    public String execute() {
		boolean ok = CassiereDAOFactory.getDAO().creaCassiere(getCassiere());
		if(ok) {
			addActionMessage(getText("action.add.success"));
			return SUCCESS;
		} else {
			addActionError(getText("action.add.error"));
			return INPUT;
		}
    }
	
	@Override
	public void validate() {
    	setSale(SalaGiochiDAOFactory.getDAO().getLista());
	}

	public Cassiere getCassiere() {
		return cassiere;
	}

	public void setCassiere(Cassiere cassiere) {
		this.cassiere = cassiere;
	}

	public List<SalaGiochi> getSale() {
		return sale;
	}

	public void setSale(List<SalaGiochi> sale) {
		this.sale = sale;
	}
}
