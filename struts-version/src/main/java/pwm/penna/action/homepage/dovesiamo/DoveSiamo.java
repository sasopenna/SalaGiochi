package pwm.penna.action.homepage.dovesiamo;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import pwm.penna.pojo.salagiochi.SalaGiochiDAOFactory;
import pwm.penna.pojo.salagiochi.SalaGiochi;


public class DoveSiamo extends ActionSupport { 
	private static final long serialVersionUID = 1L;
	private List<SalaGiochi> sale;
	
	@Override 
	public String execute() {
		setSale(SalaGiochiDAOFactory.getDAO().getLista());
		return SUCCESS; 
	}

	public List<SalaGiochi> getSale() {
		return sale;
	}

	public void setSale(List<SalaGiochi> sale) {
		this.sale = sale;
	}
}
