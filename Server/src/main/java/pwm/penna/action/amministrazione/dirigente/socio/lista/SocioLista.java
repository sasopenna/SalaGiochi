package pwm.penna.action.amministrazione.dirigente.socio.lista;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import pwm.penna.pojo.socio.Socio;
import pwm.penna.pojo.socio.SocioDAOFactory;

public class SocioLista extends ActionSupport {
	private static final long serialVersionUID = 1L;
	
	private List<Socio> soci;

    @Override
    public String execute() {
    	setSoci(SocioDAOFactory.getDAO().getLista());
    	return SUCCESS;
    }

	public List<Socio> getSoci() {
		return soci;
	}

	public void setSoci(List<Socio> soci) {
		this.soci = soci;
	}
}
