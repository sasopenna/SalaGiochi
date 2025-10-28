package pwm.penna.action.amministrazione.dirigente.socio.inserisci;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import pwm.penna.pojo.cliente.ClienteDAOFactory;
import pwm.penna.pojo.socio.Socio;
import pwm.penna.pojo.socio.SocioDAOFactory;

public class SocioCrea extends ActionSupport {
	private static final long serialVersionUID = 1L;

	private Socio socio;
	private List<Integer> notSoci;

	@Override
    public String execute() {
		boolean ok = SocioDAOFactory.getDAO().creaSocio(getSocio());
		if(ok) {
			addActionMessage(getText("action.add.success"));
			return SUCCESS;
		} else {
			addActionError(getText("action.add.error"));
			return INPUT;
		}
    }
	
	@Override
	public void validate() {
    	setNotSoci(ClienteDAOFactory.getDAO().getListaNotSoci());
	}

	public Socio getSocio() {
		return socio;
	}

	public void setSocio(Socio socio) {
		this.socio = socio;
	}

	public List<Integer> getNotSoci() {
		return notSoci;
	}

	public void setNotSoci(List<Integer> notSoci) {
		this.notSoci = notSoci;
	}
}
