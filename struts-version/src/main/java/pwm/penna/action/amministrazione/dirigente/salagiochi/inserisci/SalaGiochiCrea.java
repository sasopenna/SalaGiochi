package pwm.penna.action.amministrazione.dirigente.salagiochi.inserisci;

import com.opensymphony.xwork2.ActionSupport;

import pwm.penna.pojo.salagiochi.SalaGiochi;
import pwm.penna.pojo.salagiochi.SalaGiochiDAOFactory;

public class SalaGiochiCrea extends ActionSupport {
	private static final long serialVersionUID = 1L;

	private SalaGiochi salagiochi;

	@Override
    public String execute() {
		boolean ok = SalaGiochiDAOFactory.getDAO().creaSala(getSalagiochi());
		if(ok) {
			addActionMessage(getText("action.add.success"));
			return SUCCESS;
		} else {
			addActionError(getText("action.add.error"));
			return INPUT;
		}
    }

	public SalaGiochi getSalagiochi() {
		return salagiochi;
	}

	public void setSalagiochi(SalaGiochi salagiochi) {
		this.salagiochi = salagiochi;
	}
}
