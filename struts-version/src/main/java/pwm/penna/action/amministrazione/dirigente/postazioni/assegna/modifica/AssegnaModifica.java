package pwm.penna.action.amministrazione.dirigente.postazioni.assegna.modifica;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import pwm.penna.pojo.assegna.Assegna;
import pwm.penna.pojo.assegna.AssegnaDAOFactory;
import pwm.penna.pojo.cassiere.Cassiere;
import pwm.penna.pojo.cassiere.CassiereDAOFactory;


public class AssegnaModifica extends ActionSupport {
	private static final long serialVersionUID = 1L;

	private List<Cassiere> cassieri;
	private Assegna assegnazione;
	private int id;

    @Override
    public String execute() {
    	setCassieri(CassiereDAOFactory.getDAO().getLista());
    	setAssegnazione(AssegnaDAOFactory.getDAO().getAssegnazione(getId()));
    	return INPUT;
    }
    
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
