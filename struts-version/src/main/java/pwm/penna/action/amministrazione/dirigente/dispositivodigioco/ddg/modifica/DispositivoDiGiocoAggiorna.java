package pwm.penna.action.amministrazione.dirigente.dispositivodigioco.ddg.modifica;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import pwm.penna.pojo.dispositivodigioco.DispositivoDiGioco;
import pwm.penna.pojo.dispositivodigioco.DispositivoDiGiocoDAOFactory;
import pwm.penna.pojo.dispositivodigioco.DispositivoDiGiocoTipoFactory;
import pwm.penna.pojo.dispositivodigioco.tipo.PC;
import pwm.penna.pojo.dispositivodigioco.tipo.PlayStation;
import pwm.penna.pojo.dispositivodigioco.tipo.Xbox;
import pwm.penna.utils.validators.ddg.DispositivoValidatorFactory;

public class DispositivoDiGiocoAggiorna extends ActionSupport {
	private static final long serialVersionUID = 1L;
	
	private List<String> dispositivi = DispositivoValidatorFactory.getDispositivoDiGiocoValidator().getLista();
	private List<String> discriminatorPlayStation = DispositivoValidatorFactory.getPlayStationValidator().getLista();
	private List<String> discriminatorWindows = DispositivoValidatorFactory.getWindowsValidator().getLista();
	private List<String> discriminatorXbox = DispositivoValidatorFactory.getXboxValidator().getLista();
	
	private DispositivoDiGioco dispositivoDiGioco;
	private String tipo;
	private String discriminator;

	@Override
    public String execute() {
		
		boolean ok = DispositivoDiGiocoDAOFactory.getDAO().aggiornaDispositivo(getDispositivoDiGioco());
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
		//singoli check per ogni tipo, se non avessi fatto così avrei dovuto creare 3 dispositivoaggiorna/crea diversi per ogni tipo
		
		if(tipo.equals(PC.DISCRIMINATOR)) {
			if(!DispositivoValidatorFactory.getWindowsValidator().check(discriminator)) {
				this.addFieldError("discriminator", getText("validator.invalid_version"));
			}
		} else if(tipo.equals(Xbox.DISCRIMINATOR)) {
			if(!DispositivoValidatorFactory.getXboxValidator().check(discriminator)) {
				this.addFieldError("discriminator", getText("validator.invalid_version"));
			}
		} else if(tipo.equals(PlayStation.DISCRIMINATOR)) {
			if(!DispositivoValidatorFactory.getPlayStationValidator().check(discriminator)) {
				this.addFieldError("discriminator", getText("validator.invalid_version"));
			}
		} else {
			this.addFieldError("tipo", getText("validator.invalid_device"));
			return;
		}
		
		setDispositivoDiGioco(DispositivoDiGiocoTipoFactory.crea(tipo, getDispositivoDiGioco(), discriminator));
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getDiscriminator() {
		return discriminator;
	}

	public void setDiscriminator(String discriminator) {
		this.discriminator = discriminator;
	}

	public DispositivoDiGioco getDispositivoDiGioco() {
		return dispositivoDiGioco;
	}

	public void setDispositivoDiGioco(DispositivoDiGioco dispositivoDiGioco) {
		this.dispositivoDiGioco = dispositivoDiGioco;
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
}
