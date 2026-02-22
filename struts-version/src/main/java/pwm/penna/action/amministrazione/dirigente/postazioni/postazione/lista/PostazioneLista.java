package pwm.penna.action.amministrazione.dirigente.postazioni.postazione.lista;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import pwm.penna.pojo.postazione.Postazione;
import pwm.penna.pojo.postazione.PostazioneDAOFactory;

public class PostazioneLista extends ActionSupport {
	private static final long serialVersionUID = 1L;
	
	private List<Postazione> postazioni;

    @Override
    public String execute() {
    	setPostazioni(PostazioneDAOFactory.getDAO().getLista());
    	return SUCCESS;
    }

	public List<Postazione> getPostazioni() {
		return postazioni;
	}

	public void setPostazioni(List<Postazione> postazioni) {
		this.postazioni = postazioni;
	}
}
