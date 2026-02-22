package pwm.penna.action.amministrazione.dirigente.dispositivodigioco.ripara.lista;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import pwm.penna.pojo.ripara.Ripara;
import pwm.penna.pojo.ripara.RiparaDAOFactory;

public class RiparaLista extends ActionSupport {
	private static final long serialVersionUID = 1L;
	
	private List<Ripara> riparazioni;

    @Override
    public String execute() {
    	setRiparazioni(RiparaDAOFactory.getDAO().getLista());
    	return SUCCESS;
    }

	public List<Ripara> getRiparazioni() {
		return riparazioni;
	}

	public void setRiparazioni(List<Ripara> riparazioni) {
		this.riparazioni = riparazioni;
	}
}
