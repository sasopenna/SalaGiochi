package pwm.penna.action.homepage.statistiche;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import pwm.penna.pojo.dispositivodigioco.tipo.PC;
import pwm.penna.pojo.dispositivodigioco.tipo.PlayStation;
import pwm.penna.pojo.dispositivodigioco.tipo.Xbox;
import pwm.penna.pojo.richiede.RichiedeDAO;
import pwm.penna.pojo.richiede.RichiedeDAOFactory;
import pwm.penna.pojo.socio.Socio;
import pwm.penna.pojo.socio.SocioDAO;
import pwm.penna.pojo.socio.SocioDAOFactory;

public class Statistiche extends ActionSupport {
	private static final long serialVersionUID = 1L;
	
	private long uomo, donna, pc, xbox, play;
    private List<Socio> top5, fedeli5;

    @Override
    public String execute() {
		SocioDAO socioDAO = SocioDAOFactory.getDAO();
		setUomo(socioDAO.countSociPerSesso("Uomo"));
		setDonna(socioDAO.countSociPerSesso("Donna"));
		setTop5(socioDAO.orderSoci("punteggio", "desc", 5));
		setFedeli5(socioDAO.orderSoci("membroDal", "asc", 5));
		
		RichiedeDAO richiedeDAO = RichiedeDAOFactory.getDAO();
		setPc(richiedeDAO.countRichiestePerConsole(PC.class));
		setXbox(richiedeDAO.countRichiestePerConsole(Xbox.class));
		setPlay(richiedeDAO.countRichiestePerConsole(PlayStation.class));
        return SUCCESS;
    }

	public long getUomo() {
		return uomo;
	}

	public void setUomo(long uomo) {
		this.uomo = uomo;
	}

	public long getDonna() {
		return donna;
	}

	public void setDonna(long donna) {
		this.donna = donna;
	}

	public long getPc() {
		return pc;
	}

	public void setPc(long pc) {
		this.pc = pc;
	}

	public long getXbox() {
		return xbox;
	}

	public void setXbox(long xbox) {
		this.xbox = xbox;
	}

	public long getPlay() {
		return play;
	}

	public void setPlay(long play) {
		this.play = play;
	}

	public List<Socio> getTop5() {
		return top5;
	}

	public void setTop5(List<Socio> top5) {
		this.top5 = top5;
	}

	public List<Socio> getFedeli5() {
		return fedeli5;
	}

	public void setFedeli5(List<Socio> fedeli5) {
		this.fedeli5 = fedeli5;
	}
}
