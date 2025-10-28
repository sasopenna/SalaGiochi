package pwm.penna.action.amministrazione.dirigente.dipendenti.dirigente.inserisci;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.opensymphony.xwork2.ActionSupport;

import pwm.penna.pojo.dirigente.Dirigente;
import pwm.penna.pojo.dirigente.DirigenteDAOFactory;
import pwm.penna.pojo.salagiochi.SalaGiochi;
import pwm.penna.pojo.salagiochi.SalaGiochiDAOFactory;

public class DirigenteCrea extends ActionSupport {
	private static final long serialVersionUID = 1L;

	private Dirigente dirigente;
 	private List<Integer> salegiochi;

	@Override
    public String execute() {
		Set<SalaGiochi> saleDirigente = new HashSet<>();
		for(Integer i : salegiochi) {
			saleDirigente.add(SalaGiochiDAOFactory.getDAO().getSala(i));
		}
		dirigente.setSale(saleDirigente);

		boolean ok = DirigenteDAOFactory.getDAO().creaDirigente(getDirigente());
		if(ok) {
			addActionMessage(getText("action.add.success"));
			return SUCCESS;
		} else {
			addActionError(getText("action.add.error"));
			return INPUT;
		}
    }
	
	public Dirigente getDirigente() {
		return dirigente;
	}

	public void setDirigente(Dirigente dirigente) {
		this.dirigente = dirigente;
	}

	public List<Integer> getSalegiochi() {
		return salegiochi;
	}

	public void setSalegiochi(List<Integer> salegiochi) {
		this.salegiochi = salegiochi;
	}
}
