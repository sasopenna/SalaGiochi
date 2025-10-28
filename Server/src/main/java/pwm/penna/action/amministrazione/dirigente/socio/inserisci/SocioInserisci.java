package pwm.penna.action.amministrazione.dirigente.socio.inserisci;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import pwm.penna.pojo.cliente.ClienteDAOFactory;
import pwm.penna.pojo.socio.Socio;

public class SocioInserisci extends ActionSupport {
	private static final long serialVersionUID = 1L;
	
	private Socio socio;
	private List<Integer> notSoci;

    @Override
    public String execute() {
    	setNotSoci(ClienteDAOFactory.getDAO().getListaNotSoci());
    	return SUCCESS;
    }
    
	public List<Integer> getNotSoci() {
		return notSoci;
	}

	public void setNotSoci(List<Integer> notSoci) {
		this.notSoci = notSoci;
	}

	public Socio getSocio() {
		return socio;
	}

	public void setSocio(Socio socio) {
		this.socio = socio;
	}
}
