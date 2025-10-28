package pwm.penna.action.amministrazione.dirigente.salagiochi.modifica;

import com.opensymphony.xwork2.ActionSupport;

import pwm.penna.pojo.salagiochi.SalaGiochi;
import pwm.penna.pojo.salagiochi.SalaGiochiDAOFactory;

public class SalaGiochiModifica extends ActionSupport {
	private static final long serialVersionUID = 1L;
	
	private SalaGiochi salagiochi;
	private int id;

    @Override
    public String execute() {
    	setSalagiochi(SalaGiochiDAOFactory.getDAO().getSala(getId()));
    	return INPUT;
    }
    
	public SalaGiochi getSalagiochi() {
		return salagiochi;
	}

	public void setSalagiochi(SalaGiochi salagiochi) {
		this.salagiochi = salagiochi;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
