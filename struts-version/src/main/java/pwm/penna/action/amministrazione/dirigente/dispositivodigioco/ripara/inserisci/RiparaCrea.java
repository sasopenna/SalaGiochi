package pwm.penna.action.amministrazione.dirigente.dispositivodigioco.ripara.inserisci;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import pwm.penna.pojo.dispositivodigioco.DispositivoDiGioco;
import pwm.penna.pojo.dispositivodigioco.DispositivoDiGiocoDAOFactory;
import pwm.penna.pojo.ripara.Ripara;
import pwm.penna.pojo.ripara.RiparaDAOFactory;
import pwm.penna.pojo.tecnico.Tecnico;
import pwm.penna.pojo.tecnico.TecnicoDAOFactory;

public class RiparaCrea extends ActionSupport {
	private static final long serialVersionUID = 1L;

	private Ripara ripara;
 	private List<Tecnico> tecnici;
 	private List<DispositivoDiGioco> dispositivi;

	@Override
    public String execute() {
		boolean ok = RiparaDAOFactory.getDAO().creaRiparazione(getRipara());
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
    	setTecnici(TecnicoDAOFactory.getDAO().getLista());
    	setDispositivi(DispositivoDiGiocoDAOFactory.getDAO().getLista());
	}

	public Ripara getRipara() {
		return ripara;
	}

	public void setRipara(Ripara ripara) {
		this.ripara = ripara;
	}

	public List<Tecnico> getTecnici() {
		return tecnici;
	}

	public void setTecnici(List<Tecnico> tecnici) {
		this.tecnici = tecnici;
	}

	public List<DispositivoDiGioco> getDispositivi() {
		return dispositivi;
	}

	public void setDispositivi(List<DispositivoDiGioco> dispositivi) {
		this.dispositivi = dispositivi;
	}
}
