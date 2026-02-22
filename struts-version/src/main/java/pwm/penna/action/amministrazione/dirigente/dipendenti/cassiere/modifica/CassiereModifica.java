package pwm.penna.action.amministrazione.dirigente.dipendenti.cassiere.modifica;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import pwm.penna.pojo.cassiere.Cassiere;
import pwm.penna.pojo.cassiere.CassiereDAOFactory;
import pwm.penna.pojo.salagiochi.SalaGiochi;
import pwm.penna.pojo.salagiochi.SalaGiochiDAOFactory;

public class CassiereModifica extends ActionSupport {
	private static final long serialVersionUID = 1L;
	
	private Cassiere cassiere;
	private List<SalaGiochi> sale;
 	private int id;

    @Override
    public String execute() {
    	setSale(SalaGiochiDAOFactory.getDAO().getLista());
    	setCassiere(CassiereDAOFactory.getDAO().getCassiere(getId()));
    	return INPUT;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Cassiere getCassiere() {
		return cassiere;
	}

	public void setCassiere(Cassiere cassiere) {
		this.cassiere = cassiere;
	}

	public List<SalaGiochi> getSale() {
		return sale;
	}

	public void setSale(List<SalaGiochi> sale) {
		this.sale = sale;
	}
}
