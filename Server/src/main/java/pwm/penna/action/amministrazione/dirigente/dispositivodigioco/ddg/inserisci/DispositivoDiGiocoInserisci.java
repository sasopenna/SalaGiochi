package pwm.penna.action.amministrazione.dirigente.dispositivodigioco.ddg.inserisci;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import pwm.penna.pojo.dispositivodigioco.DispositivoDiGioco;
import pwm.penna.utils.validators.ddg.DispositivoValidatorFactory;

public class DispositivoDiGiocoInserisci extends ActionSupport {
	private static final long serialVersionUID = 1L;

	private List<String> dispositivi = DispositivoValidatorFactory.getDispositivoDiGiocoValidator().getLista();
	private List<String> discriminatorPlayStation = DispositivoValidatorFactory.getPlayStationValidator().getLista();
	private List<String> discriminatorWindows = DispositivoValidatorFactory.getWindowsValidator().getLista();
	private List<String> discriminatorXbox = DispositivoValidatorFactory.getXboxValidator().getLista();
	
	private DispositivoDiGioco dispositivoDiGioco;

    @Override
    public String execute() {
    	return SUCCESS;
    }

	public List<String> getDispositivi() {
		return dispositivi;
	}

	public void setDispositivi(List<String> dispositivi) {
		this.dispositivi = dispositivi;
	}

	public List<String> getDiscriminatorWindows() {
		return discriminatorWindows;
	}

	public void setDiscriminatorWindows(List<String> discriminatorWindows) {
		this.discriminatorWindows = discriminatorWindows;
	}

	public List<String> getDiscriminatorXbox() {
		return discriminatorXbox;
	}

	public void setDiscriminatorXbox(List<String> discriminatorXbox) {
		this.discriminatorXbox = discriminatorXbox;
	}

	public List<String> getDiscriminatorPlayStation() {
		return discriminatorPlayStation;
	}

	public void setDiscriminatorPlayStation(List<String> discriminatorPlayStation) {
		this.discriminatorPlayStation = discriminatorPlayStation;
	}

	public DispositivoDiGioco getDispositivoDiGioco() {
		return dispositivoDiGioco;
	}

	public void setDispositivoDiGioco(DispositivoDiGioco dispositivoDiGioco) {
		this.dispositivoDiGioco = dispositivoDiGioco;
	}
}
