package pwm.penna.pojo.dispositivodigioco.tipo;

import java.sql.Date;

import pwm.penna.pojo.dispositivodigioco.DispositivoDiGioco;

public class Xbox extends DispositivoDiGioco {
	private static final long serialVersionUID = 1L;

	public final static String DISCRIMINATOR = "Xbox";
	
	private String generazione;
	
	public Xbox() {
        super();
    }

    public Xbox(Integer id, Date dataAcquisizione, String generazione) {
        super(id, dataAcquisizione);
        this.generazione = generazione;
    }

    public Xbox(DispositivoDiGioco d, String generazione) {
        this(d.getId(), d.getDataAcquisizione(), generazione);
    }

	public String getGenerazione() {
		return generazione;
	}

	public void setGenerazione(String generazione) {
		this.generazione = generazione;
	}
}
