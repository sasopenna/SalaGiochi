package pwm.penna.action.amministrazione.dirigente.dispositivodigioco.ripara.inserisci;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import pwm.penna.pojo.dispositivodigioco.DispositivoDiGioco;
import pwm.penna.pojo.dispositivodigioco.DispositivoDiGiocoDAOFactory;
import pwm.penna.pojo.ripara.Ripara;
import pwm.penna.pojo.tecnico.Tecnico;
import pwm.penna.pojo.tecnico.TecnicoDAOFactory;

public class RiparaInserisci extends ActionSupport {
	private static final long serialVersionUID = 1L;
	
	private Ripara ripara;
 	private List<Tecnico> tecnici;
 	private List<DispositivoDiGioco> dispositivi;

    @Override
    public String execute() {
    	setTecnici(TecnicoDAOFactory.getDAO().getLista());
    	setDispositivi(DispositivoDiGiocoDAOFactory.getDAO().getLista());
    	return SUCCESS;
    }

	public Ripara getRipara() {
		return ripara;
	}

	public void setRipara(Ripara ripara) {
		this.ripara = ripara;
	}

	public List<DispositivoDiGioco> getDispositivi() {
		return dispositivi;
	}

	public void setDispositivi(List<DispositivoDiGioco> dispositivi) {
		this.dispositivi = dispositivi;
	}

	public List<Tecnico> getTecnici() {
		return tecnici;
	}

	public void setTecnici(List<Tecnico> tecnici) {
		this.tecnici = tecnici;
	}
}
