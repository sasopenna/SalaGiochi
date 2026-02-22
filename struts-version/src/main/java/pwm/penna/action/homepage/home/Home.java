package pwm.penna.action.homepage.home;

import com.opensymphony.xwork2.ActionSupport;

import pwm.penna.pojo.cassiere.CassiereDAOFactory;
import pwm.penna.pojo.dirigente.DirigenteDAOFactory;
import pwm.penna.pojo.dispositivodigioco.DispositivoDiGiocoDAOFactory;
import pwm.penna.pojo.salagiochi.SalaGiochiDAOFactory;
import pwm.penna.pojo.socio.SocioDAOFactory;
import pwm.penna.pojo.tecnico.TecnicoDAOFactory;

public class Home extends ActionSupport { 
	private static final long serialVersionUID = 1L;
	
	private long sale, soci, ddg, dipendenti, dirigenti, cassieri, tecnici;
	
	@Override 
	public String execute() {
		setDdg(DispositivoDiGiocoDAOFactory.getDAO().countDispositivi());
		setDirigenti(DirigenteDAOFactory.getDAO().countDirigenti());
		setCassieri(CassiereDAOFactory.getDAO().countCassieri());
		setTecnici(TecnicoDAOFactory.getDAO().countTecnici());
		setSale(SalaGiochiDAOFactory.getDAO().countSale());
		setSoci(SocioDAOFactory.getDAO().countSoci());
		setDipendenti(getDirigenti() + getCassieri() + getTecnici());
		return SUCCESS; 
	}

	public long getSale() {
		return sale;
	}

	public void setSale(long sale) {
		this.sale = sale;
	}

	public long getSoci() {
		return soci;
	}

	public void setSoci(long soci) {
		this.soci = soci;
	}

	public long getDdg() {
		return ddg;
	}

	public void setDdg(long ddg) {
		this.ddg = ddg;
	}

	public long getDipendenti() {
		return dipendenti;
	}

	public void setDipendenti(long dipendenti) {
		this.dipendenti = dipendenti;
	}

	public long getDirigenti() {
		return dirigenti;
	}

	public void setDirigenti(long dirigenti) {
		this.dirigenti = dirigenti;
	}

	public long getCassieri() {
		return cassieri;
	}

	public void setCassieri(long cassieri) {
		this.cassieri = cassieri;
	}

	public long getTecnici() {
		return tecnici;
	}

	public void setTecnici(long tecnici) {
		this.tecnici = tecnici;
	}
}
