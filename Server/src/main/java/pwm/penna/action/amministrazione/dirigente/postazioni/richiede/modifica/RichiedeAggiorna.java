package pwm.penna.action.amministrazione.dirigente.postazioni.richiede.modifica;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import pwm.penna.pojo.cliente.Cliente;
import pwm.penna.pojo.cliente.ClienteDAOFactory;
import pwm.penna.pojo.postazione.Postazione;
import pwm.penna.pojo.postazione.PostazioneDAOFactory;
import pwm.penna.pojo.richiede.Richiede;
import pwm.penna.pojo.richiede.RichiedeDAOFactory;

public class RichiedeAggiorna extends ActionSupport {
	private static final long serialVersionUID = 1L;

	private List<Cliente> clienti;
	private List<Postazione> postazioni;
	private Richiede richiesta;

	@Override
    public String execute() {
		richiesta.setPostazione(PostazioneDAOFactory.getDAO().getPostazione(richiesta.getPostazione().getNumero()));
		
		boolean ok = RichiedeDAOFactory.getDAO().aggiornaRichiesta(richiesta);
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
    	setPostazioni(PostazioneDAOFactory.getDAO().getLista());
    	setClienti(ClienteDAOFactory.getDAO().getLista());
	}

	public List<Cliente> getClienti() {
		return clienti;
	}

	public void setClienti(List<Cliente> clienti) {
		this.clienti = clienti;
	}

	public List<Postazione> getPostazioni() {
		return postazioni;
	}

	public void setPostazioni(List<Postazione> postazioni) {
		this.postazioni = postazioni;
	}

	public Richiede getRichiesta() {
		return richiesta;
	}

	public void setRichiesta(Richiede richiesta) {
		this.richiesta = richiesta;
	}
}
