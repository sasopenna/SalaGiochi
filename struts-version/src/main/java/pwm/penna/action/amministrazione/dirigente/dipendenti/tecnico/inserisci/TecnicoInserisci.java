package pwm.penna.action.amministrazione.dirigente.dipendenti.tecnico.inserisci;

import com.opensymphony.xwork2.ActionSupport;

import pwm.penna.pojo.tecnico.Tecnico;

public class TecnicoInserisci extends ActionSupport {
	private static final long serialVersionUID = 1L;
	
	private Tecnico tecnico;

    @Override
    public String execute() {
    	return SUCCESS;
    }

	public Tecnico getTecnico() {
		return tecnico;
	}

	public void setTecnico(Tecnico tecnico) {
		this.tecnico = tecnico;
	}
}
