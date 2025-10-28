package pwm.penna.action.amministrazione.dirigente.postazioni.postazione.inserisci;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import pwm.penna.pojo.dispositivodigioco.DispositivoDiGioco;
import pwm.penna.pojo.dispositivodigioco.DispositivoDiGiocoDAOFactory;
import pwm.penna.pojo.postazione.Postazione;
import pwm.penna.pojo.salagiochi.SalaGiochi;
import pwm.penna.pojo.salagiochi.SalaGiochiDAOFactory;

public class PostazioneInserisci extends ActionSupport {
	private static final long serialVersionUID = 1L;

	private List<DispositivoDiGioco> dispositivi;
	private List<SalaGiochi> sale;
	private Postazione postazione;

    @Override
    public String execute() {
    	setDispositivi(DispositivoDiGiocoDAOFactory.getDAO().getListaNotTaken(null));
    	setSale(SalaGiochiDAOFactory.getDAO().getLista());
    	return SUCCESS;
    }
	
	public List<DispositivoDiGioco> getDispositivi() {
		return dispositivi;
	}
	
	public void setDispositivi(List<DispositivoDiGioco> dispositivi) {
		this.dispositivi = dispositivi;
	}
	
	public List<SalaGiochi> getSale() {
		return sale;
	}
	
	public void setSale(List<SalaGiochi> sale) {
		this.sale = sale;
	}
	
	public Postazione getPostazione() {
		return postazione;
	}
	
	public void setPostazione(Postazione postazione) {
		this.postazione = postazione;
	}
}
