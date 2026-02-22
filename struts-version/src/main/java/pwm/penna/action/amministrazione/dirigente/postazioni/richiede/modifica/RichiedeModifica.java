package pwm.penna.action.amministrazione.dirigente.postazioni.richiede.modifica;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import pwm.penna.pojo.cliente.Cliente;
import pwm.penna.pojo.cliente.ClienteDAOFactory;
import pwm.penna.pojo.postazione.Postazione;
import pwm.penna.pojo.postazione.PostazioneDAOFactory;
import pwm.penna.pojo.richiede.Richiede;
import pwm.penna.pojo.richiede.RichiedeDAOFactory;


public class RichiedeModifica extends ActionSupport {
	private static final long serialVersionUID = 1L;

	private List<Cliente> clienti;
	private List<Postazione> postazioni;
	private Richiede richiesta;
	private int id;

    @Override
    public String execute() {
    	setRichiesta(RichiedeDAOFactory.getDAO().getRichiesta(getId()));
    	setPostazioni(PostazioneDAOFactory.getDAO().getLista());
    	setClienti(ClienteDAOFactory.getDAO().getLista());
    	return INPUT;
    }
    
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
