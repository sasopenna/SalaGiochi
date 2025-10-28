package pwm.penna.action.amministrazione.dirigente.socio.modifica;

import com.opensymphony.xwork2.ActionSupport;

import pwm.penna.pojo.socio.Socio;
import pwm.penna.pojo.socio.SocioDAOFactory;

public class SocioModifica extends ActionSupport {
	private static final long serialVersionUID = 1L;
	
	private Socio socio;
	private Integer id;

    @Override
    public String execute() {
    	setSocio(SocioDAOFactory.getDAO().getSocio(getId()));
    	return INPUT;
    }

	public Socio getSocio() {
		return socio;
	}

	public void setSocio(Socio socio) {
		this.socio = socio;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}
