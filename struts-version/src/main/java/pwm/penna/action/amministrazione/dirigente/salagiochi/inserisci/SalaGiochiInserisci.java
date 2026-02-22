package pwm.penna.action.amministrazione.dirigente.salagiochi.inserisci;

import com.opensymphony.xwork2.ActionSupport;

import pwm.penna.pojo.salagiochi.SalaGiochi;

public class SalaGiochiInserisci extends ActionSupport {
	private static final long serialVersionUID = 1L;
	
	private SalaGiochi salagiochi;

    @Override
    public String execute() {
    	return SUCCESS;
    }

	public SalaGiochi getSalagiochi() {
		return salagiochi;
	}

	public void setSalagiochi(SalaGiochi salagiochi) {
		this.salagiochi = salagiochi;
	}
}
