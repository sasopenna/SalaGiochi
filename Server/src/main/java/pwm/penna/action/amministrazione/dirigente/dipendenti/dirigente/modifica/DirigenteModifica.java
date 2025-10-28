package pwm.penna.action.amministrazione.dirigente.dipendenti.dirigente.modifica;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import pwm.penna.pojo.dirigente.Dirigente;
import pwm.penna.pojo.dirigente.DirigenteDAOFactory;
import pwm.penna.pojo.salagiochi.SalaGiochi;
import pwm.penna.pojo.salagiochi.SalaGiochiDAOFactory;

public class DirigenteModifica extends ActionSupport {
	private static final long serialVersionUID = 1L;
	
	private Dirigente dirigente;
 	private int id;
 	private List<SalaGiochi> sale;

    @Override
    public String execute() {
    	setSale(SalaGiochiDAOFactory.getDAO().getLista());
    	setDirigente(DirigenteDAOFactory.getDAO().getDirigente(getId()));
    	return INPUT;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Dirigente getDirigente() {
		return dirigente;
	}

	public void setDirigente(Dirigente dirigente) {
		this.dirigente = dirigente;
	}

	public List<SalaGiochi> getSale() {
		return sale;
	}

	public void setSale(List<SalaGiochi> sale) {
		this.sale = sale;
	}
}
