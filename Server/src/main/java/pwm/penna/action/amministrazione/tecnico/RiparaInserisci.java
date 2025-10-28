package pwm.penna.action.amministrazione.tecnico;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import pwm.penna.pojo.dispositivodigioco.DispositivoDiGioco;
import pwm.penna.pojo.dispositivodigioco.DispositivoDiGiocoDAOFactory;
import pwm.penna.pojo.ripara.Ripara;
import pwm.penna.pojo.tecnico.Tecnico;
import pwm.penna.pojo.tecnico.TecnicoDAOFactory;
import pwm.penna.utils.interceptors.account.AccountAware;
import pwm.penna.utils.interceptors.account.AccountSession;

public class RiparaInserisci extends ActionSupport implements AccountAware {
	private static final long serialVersionUID = 1L;

 	private List<DispositivoDiGioco> dispositivi;
	private Ripara ripara;
 	private AccountSession account;

    @Override
    public String execute() {
    	Tecnico tecnico = TecnicoDAOFactory.getDAO().getTecnico(account.getAccount().getProfilo().getDipendente().getIdDipendente());
    	
    	ripara = new Ripara();
    	ripara.setTecnico(tecnico);

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

	@Override
	public void setAccount(AccountSession account) {
		this.account = account;
	}
}
