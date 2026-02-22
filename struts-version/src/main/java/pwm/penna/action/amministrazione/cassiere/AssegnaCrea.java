package pwm.penna.action.amministrazione.cassiere;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import pwm.penna.pojo.assegna.Assegna;
import pwm.penna.pojo.assegna.AssegnaDAOFactory;
import pwm.penna.pojo.cassiere.Cassiere;
import pwm.penna.pojo.cassiere.CassiereDAOFactory;
import pwm.penna.pojo.richiede.Richiede;
import pwm.penna.pojo.richiede.RichiedeDAOFactory;
import pwm.penna.utils.interceptors.account.AccountAware;
import pwm.penna.utils.interceptors.account.AccountSession;

public class AssegnaCrea extends ActionSupport implements AccountAware {
	private static final long serialVersionUID = 1L;

	private List<Richiede> richieste;
	private Assegna assegnazione;
	private AccountSession account;

	@Override
    public String execute() {
		assegnazione.setRichiede(RichiedeDAOFactory.getDAO().getRichiesta(assegnazione.getPrenotazione()));

		boolean ok = AssegnaDAOFactory.getDAO().creaAssegnazione(assegnazione);
		if(ok) {
			addActionMessage(getText("action.add.success"));
			return SUCCESS;
		} else {
			addActionError(getText("action.add.error"));
			return INPUT;
		}
    }
	
	@Override
	public void validate() {
    	Cassiere cassiere = CassiereDAOFactory.getDAO().getCassiere(account.getAccount().getProfilo().getDipendente().getIdDipendente());
    	assegnazione.setCassiere(cassiere);
    	//filtro solo le postazioni per la sala giochi del cassiere
    	setRichieste(RichiedeDAOFactory.getDAO().getListaNonAssegnatePerSala(cassiere.getSalaGiochi()));
	}

	public List<Richiede> getRichieste() {
		return richieste;
	}

	public void setRichieste(List<Richiede> richieste) {
		this.richieste = richieste;
	}

	public Assegna getAssegnazione() {
		return assegnazione;
	}

	public void setAssegnazione(Assegna assegnazione) {
		this.assegnazione = assegnazione;
	}

	@Override
	public void setAccount(AccountSession account) {
		this.account = account;
	}
}
