package pwm.penna.action.amministrazione.dirigente.dispositivodigioco.ripara.modifica;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import pwm.penna.pojo.dispositivodigioco.DispositivoDiGioco;
import pwm.penna.pojo.dispositivodigioco.DispositivoDiGiocoDAOFactory;
import pwm.penna.pojo.ripara.Ripara;
import pwm.penna.pojo.ripara.RiparaDAOFactory;
import pwm.penna.pojo.tecnico.Tecnico;
import pwm.penna.pojo.tecnico.TecnicoDAOFactory;

public class RiparaModifica extends ActionSupport {
	private static final long serialVersionUID = 1L;

 	private int id;
	private Ripara ripara;
 	private List<Tecnico> tecnici;
 	private List<DispositivoDiGioco> dispositivi;

    @Override
    public String execute() {
    	setTecnici(TecnicoDAOFactory.getDAO().getLista());
    	setDispositivi(DispositivoDiGiocoDAOFactory.getDAO().getLista());
    	setRipara(RiparaDAOFactory.getDAO().getRiparazione(getId()));
    	return INPUT;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
