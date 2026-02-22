package pwm.penna.action.amministrazione.dirigente.dipendenti.dirigente.lista;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import pwm.penna.pojo.dirigente.Dirigente;
import pwm.penna.pojo.dirigente.DirigenteDAOFactory;

public class DirigenteLista extends ActionSupport {
	private static final long serialVersionUID = 1L;
	
	private List<Dirigente> dirigenti;

    @Override
    public String execute() {
    	setDirigenti(DirigenteDAOFactory.getDAO().getLista());
    	return SUCCESS;
    }

	public List<Dirigente> getDirigenti() {
		return dirigenti;
	}

	public void setDirigenti(List<Dirigente> dirigenti) {
		this.dirigenti = dirigenti;
	}
}