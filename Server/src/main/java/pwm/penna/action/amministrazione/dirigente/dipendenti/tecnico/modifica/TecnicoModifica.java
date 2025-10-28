package pwm.penna.action.amministrazione.dirigente.dipendenti.tecnico.modifica;

import com.opensymphony.xwork2.ActionSupport;

import pwm.penna.pojo.tecnico.Tecnico;
import pwm.penna.pojo.tecnico.TecnicoDAOFactory;

public class TecnicoModifica extends ActionSupport {
	private static final long serialVersionUID = 1L;
	
	private Tecnico tecnico;
 	private int id;

    @Override
    public String execute() {
    	setTecnico(TecnicoDAOFactory.getDAO().getTecnico(getId()));
    	return INPUT;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Tecnico getTecnico() {
		return tecnico;
	}

	public void setTecnico(Tecnico tecnico) {
		this.tecnico = tecnico;
	}
}
