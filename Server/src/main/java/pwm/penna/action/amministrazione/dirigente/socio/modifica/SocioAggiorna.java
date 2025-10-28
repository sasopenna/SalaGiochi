package pwm.penna.action.amministrazione.dirigente.socio.modifica;

import com.opensymphony.xwork2.ActionSupport;

import pwm.penna.pojo.socio.Socio;
import pwm.penna.pojo.socio.SocioDAOFactory;

public class SocioAggiorna extends ActionSupport {
	private static final long serialVersionUID = 1L;
	
	private Socio socio;

	@Override
    public String execute() {
		boolean ok = SocioDAOFactory.getDAO().aggiornaSocio(getSocio());
		if(ok) {
			addActionMessage(getText("action.mod.success"));
			return SUCCESS;
		} else {
			addActionError(getText("action.mod.error"));
			return INPUT;
		}
	}

	public Socio getSocio() {
		return socio;
	}

	public void setSocio(Socio socio) {
		this.socio = socio;
	}
}
