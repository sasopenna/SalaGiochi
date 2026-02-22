package pwm.penna.action.amministrazione.dirigente.postazioni.assegna.inserisci;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import pwm.penna.pojo.assegna.Assegna;
import pwm.penna.pojo.cassiere.Cassiere;
import pwm.penna.pojo.cassiere.CassiereDAOFactory;
import pwm.penna.pojo.richiede.Richiede;
import pwm.penna.pojo.richiede.RichiedeDAOFactory;

public class AssegnaInserisci extends ActionSupport {
	private static final long serialVersionUID = 1L;

	private List<Richiede> richieste;
	private List<Cassiere> cassieri;
	private Assegna assegnazione;

    @Override
    public String execute() {
    	setCassieri(CassiereDAOFactory.getDAO().getLista());
    	setRichieste(RichiedeDAOFactory.getDAO().getListaNonAssegnate());
    	return SUCCESS;
    }

	public List<Richiede> getRichieste() {
		return richieste;
	}

	public void setRichieste(List<Richiede> richieste) {
		this.richieste = richieste;
	}

	public List<Cassiere> getCassieri() {
		return cassieri;
	}

	public void setCassieri(List<Cassiere> cassieri) {
		this.cassieri = cassieri;
	}

	public Assegna getAssegnazione() {
		return assegnazione;
	}

	public void setAssegnazione(Assegna assegnazione) {
		this.assegnazione = assegnazione;
	}
}
