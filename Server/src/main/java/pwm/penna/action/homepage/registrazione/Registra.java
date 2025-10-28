package pwm.penna.action.homepage.registrazione;

import java.sql.Date;

import pwm.penna.action.homepage.login.Autenticazione;
import pwm.penna.pojo.account.Account;
import pwm.penna.pojo.cliente.ClienteDAOFactory;
import pwm.penna.pojo.profilo.Profilo;
import pwm.penna.pojo.socio.Socio;
import pwm.penna.pojo.socio.SocioDAOFactory;

public class Registra extends Autenticazione {
	private static final long serialVersionUID = 1L;

	private Profilo profilo;
	private String password;
	private String confirm_password;
	
    @Override
    public String execute() {
    	Account account = Account.fromProfilo(profilo, password);
    	profilo.setAccount(account); //bidir - si deve esplicitare la connessione
    	
    	Socio socio = new Socio();
    	socio.setCliente(ClienteDAOFactory.getDAO().creaCliente());
    	socio.setPunteggio(0);
    	socio.setMembroDal(new Date(System.currentTimeMillis()));
    	socio.setProfilo(getProfilo());
    	
    	boolean ok = SocioDAOFactory.getDAO().registraSocio(socio);
    	if(ok) {
    		// estendo la classe di Autenticazione per fare già la autenticazione invece di fare il doppio passaggio
    		super.setFromRegistration(true);
    		super.setEmail(account.getEmail());
    		super.setPassword(account.getPassword());
    		return super.execute();
    	} else {
    		this.addActionError(getText("action.register_error"));
    		return INPUT;
    	}
    }

	public String getConfirm_password() {
		return confirm_password;
	}

	public void setConfirm_password(String confirm_password) {
		this.confirm_password = confirm_password;
	}

	public Profilo getProfilo() {
		return profilo;
	}

	public void setProfilo(Profilo profilo) {
		this.profilo = profilo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
