package pwm.penna.action.amministrazione.dirigente.dipendenti.cassiere.cancella;

import com.opensymphony.xwork2.ActionSupport;

import pwm.penna.pojo.cassiere.CassiereDAOFactory;

public class CassiereCancella extends ActionSupport {
	private static final long serialVersionUID = 1L;
	
	private Integer id;

	@Override
    public String execute() {
		boolean ok = CassiereDAOFactory.getDAO().eliminaCassiere(getId());
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
