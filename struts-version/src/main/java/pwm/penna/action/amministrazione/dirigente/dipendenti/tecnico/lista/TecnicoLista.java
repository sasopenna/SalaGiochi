package pwm.penna.action.amministrazione.dirigente.dipendenti.tecnico.lista;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import pwm.penna.pojo.tecnico.Tecnico;
import pwm.penna.pojo.tecnico.TecnicoDAOFactory;

public class TecnicoLista extends ActionSupport {
	private static final long serialVersionUID = 1L;
	
	private List<Tecnico> tecnici;

    @Override
    public String execute() {
    	setTecnici(TecnicoDAOFactory.getDAO().getLista());
    	return SUCCESS;
    }

	public List<Tecnico> getTecnici() {
		return tecnici;
	}

	public void setTecnici(List<Tecnico> tecnici) {
		this.tecnici = tecnici;
	}
}