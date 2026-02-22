package pwm.penna.action.amministrazione.dirigente.postazioni.assegna.lista;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import pwm.penna.pojo.assegna.Assegna;
import pwm.penna.pojo.assegna.AssegnaDAOFactory;

public class AssegnaLista extends ActionSupport {
	private static final long serialVersionUID = 1L;
	
	private List<Assegna> assegnazioni;

    @Override
    public String execute() {
    	setAssegnazioni(AssegnaDAOFactory.getDAO().getLista());
    	return SUCCESS;
    }

	public List<Assegna> getAssegnazioni() {
		return assegnazioni;
	}

	public void setAssegnazioni(List<Assegna> assegnazioni) {
		this.assegnazioni = assegnazioni;
	}
}
