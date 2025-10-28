package pwm.penna.action.amministrazione.dirigente.dipendenti.dirigente.modifica;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.opensymphony.xwork2.ActionSupport;

import pwm.penna.pojo.dirigente.Dirigente;
import pwm.penna.pojo.dirigente.DirigenteDAOFactory;
import pwm.penna.pojo.salagiochi.SalaGiochi;
import pwm.penna.pojo.salagiochi.SalaGiochiDAOFactory;

public class DirigenteAggiorna extends ActionSupport {
	private static final long serialVersionUID = 1L;
	
	private Dirigente dirigente;
 	private List<SalaGiochi> sale;
 	private List<Integer> salegiochi;

	@Override
    public String execute() {
		Set<SalaGiochi> saleDirigente = new HashSet<>();
		for(Integer i : salegiochi) {
			saleDirigente.add(SalaGiochiDAOFactory.getDAO().getSala(i));
		}
		dirigente.setSale(saleDirigente);
		
		boolean ok = DirigenteDAOFactory.getDAO().aggiornaDirigente(getDirigente());
		if(ok) {
			addActionMessage(getText("action.mod.success"));
			return SUCCESS;
		} else {
			addActionError(getText("action.mod.error"));
			return INPUT;
		}
	}
	
	@Override
    public void validate() {
    	setSale(SalaGiochiDAOFactory.getDAO().getLista());
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

	public List<Integer> getSalegiochi() {
		return salegiochi;
	}

	public void setSalegiochi(List<Integer> salegiochi) {
		this.salegiochi = salegiochi;
	}
}
