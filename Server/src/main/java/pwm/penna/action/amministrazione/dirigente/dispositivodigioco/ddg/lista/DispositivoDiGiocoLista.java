package pwm.penna.action.amministrazione.dirigente.dispositivodigioco.ddg.lista;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import pwm.penna.pojo.dispositivodigioco.DispositivoDiGioco;
import pwm.penna.pojo.dispositivodigioco.DispositivoDiGiocoDAOFactory;

public class DispositivoDiGiocoLista extends ActionSupport {
	private static final long serialVersionUID = 1L;
	
	private List<DispositivoDiGioco> dispositivi;

    @Override
    public String execute() {
    	setDispositivi(DispositivoDiGiocoDAOFactory.getDAO().getLista());
    	return SUCCESS;
    }

	public List<DispositivoDiGioco> getDispositivi() {
		return dispositivi;
	}

	public void setDispositivi(List<DispositivoDiGioco> dispositivi) {
		this.dispositivi = dispositivi;
	}
}
