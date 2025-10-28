package pwm.penna.action.amministrazione.dirigente.salagiochi.lista;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import pwm.penna.pojo.salagiochi.SalaGiochi;
import pwm.penna.pojo.salagiochi.SalaGiochiDAOFactory;

public class SalaGiochiLista extends ActionSupport {
	private static final long serialVersionUID = 1L;
	
	private List<SalaGiochi> salagiochi;

    @Override
    public String execute() {
    	setSalagiochi(SalaGiochiDAOFactory.getDAO().getLista());
    	return SUCCESS;
    }

	public List<SalaGiochi> getSalagiochi() {
		return salagiochi;
	}

	public void setSalagiochi(List<SalaGiochi> salagiochi) {
		this.salagiochi = salagiochi;
	}
}
