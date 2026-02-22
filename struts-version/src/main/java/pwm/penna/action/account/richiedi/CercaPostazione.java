package pwm.penna.action.account.richiedi;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import pwm.penna.pojo.postazione.Postazione;
import pwm.penna.pojo.salagiochi.SalaGiochi;
import pwm.penna.pojo.salagiochi.SalaGiochiDAOFactory;

public class CercaPostazione extends ActionSupport {
	private static final long serialVersionUID = 1L;
	
	private List<Postazione> result;
	private int sala;
	private String piattaforma;

	@Override
	public String execute()  {
		result = new ArrayList<Postazione>();
		
		SalaGiochi s = SalaGiochiDAOFactory.getDAO().getSalaAndPostazioni(getSala());
		for (Postazione p : s.getPostazioni()) {
			if(piattaforma.equals(p.getDispositivoDiGioco().getTipo())) {
				result.add(p);
			}
		}
		return SUCCESS;
	}

	public List<Postazione> getResult() {
		return result;
	}

	public void setResult(List<Postazione> result) {
		this.result = result;
	}

	public int getSala() {
		return sala;
	}

	public void setSala(int sala) {
		this.sala = sala;
	}

	public String getPiattaforma() {
		return piattaforma;
	}

	public void setPiattaforma(String piattaforma) {
		this.piattaforma = piattaforma;
	}
}