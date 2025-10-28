package pwm.penna.action.amministrazione.dirigente.dipendenti.tecnico.modifica;

import com.opensymphony.xwork2.ActionSupport;

import pwm.penna.pojo.tecnico.Tecnico;
import pwm.penna.pojo.tecnico.TecnicoDAOFactory;

public class TecnicoAggiorna extends ActionSupport {
	private static final long serialVersionUID = 1L;
	
	private Tecnico tecnico;

	@Override
    public String execute() {
		boolean ok = TecnicoDAOFactory.getDAO().aggiornaTecnico(getTecnico());
		if(ok) {
			addActionMessage(getText("action.mod.success"));
			return SUCCESS;
		} else {
			addActionError(getText("action.mod.error"));
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
