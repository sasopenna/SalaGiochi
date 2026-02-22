package pwm.penna.action.amministrazione.dirigente.dipendenti.tecnico.inserisci;

import com.opensymphony.xwork2.ActionSupport;

import pwm.penna.pojo.tecnico.Tecnico;
import pwm.penna.pojo.tecnico.TecnicoDAOFactory;

public class TecnicoCrea extends ActionSupport {
	private static final long serialVersionUID = 1L;

	private Tecnico tecnico;

	@Override
    public String execute() {
		boolean ok = TecnicoDAOFactory.getDAO().creaTecnico(getTecnico());
		if(ok) {
			addActionMessage(getText("action.add.success"));
			return SUCCESS;
		} else {
			addActionError(getText("action.add.error"));
			return INPUT;
		}
    }

	public Tecnico getTecnico() {
		return tecnico;
	}

	public void setTecnico(Tecnico tecnico) {
		this.tecnico = tecnico;
	}
}
