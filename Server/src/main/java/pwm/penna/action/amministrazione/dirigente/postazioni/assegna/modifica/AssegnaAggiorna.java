package pwm.penna.action.amministrazione.dirigente.postazioni.assegna.modifica;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import pwm.penna.pojo.assegna.Assegna;
import pwm.penna.pojo.assegna.AssegnaDAOFactory;
import pwm.penna.pojo.cassiere.Cassiere;
import pwm.penna.pojo.cassiere.CassiereDAOFactory;

public class AssegnaAggiorna extends ActionSupport {
	private static final long serialVersionUID = 1L;

	private List<Cassiere> cassieri;
	private Assegna assegnazione;

	@Override
    public String execute() {
		boolean ok = AssegnaDAOFactory.getDAO().aggiornaAssegnazione(getAssegnazione());
		if(ok) {
			addActionMessage(getText("action.mod.success"));
			return SUCCESS;
		} else {
			addActionError(getText("action.mod.error"));
			return INPUT;
		}
    }
	
	@Override
	public void validate() {
    	setCassieri(CassiereDAOFactory.getDAO().getLista());
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
