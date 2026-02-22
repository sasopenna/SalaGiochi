package pwm.penna.action.amministrazione.dirigente.socio.cancella;

import com.opensymphony.xwork2.ActionSupport;

import pwm.penna.pojo.socio.SocioDAOFactory;

public class SocioCancella extends ActionSupport {
	private static final long serialVersionUID = 1L;
	
	private Integer id;

	@Override
    public String execute() {
		boolean ok = SocioDAOFactory.getDAO().eliminaSocio(getId());
		if(ok) {
			addActionMessage(getText("action.del.success"));
		} else {
			addActionError(getText("action.del.error"));
		}
		return SUCCESS;
    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}
