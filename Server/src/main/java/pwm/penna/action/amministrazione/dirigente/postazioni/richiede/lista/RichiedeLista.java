package pwm.penna.action.amministrazione.dirigente.postazioni.richiede.lista;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import pwm.penna.pojo.richiede.Richiede;
import pwm.penna.pojo.richiede.RichiedeDAOFactory;

public class RichiedeLista extends ActionSupport {
	private static final long serialVersionUID = 1L;
	
	private List<Richiede> richieste;

    @Override
    public String execute() {
    	setRichieste(RichiedeDAOFactory.getDAO().getLista());
    	return SUCCESS;
    }

	public List<Richiede> getRichieste() {
		return richieste;
	}

	public void setRichieste(List<Richiede> richieste) {
		this.richieste = richieste;
	}
}
