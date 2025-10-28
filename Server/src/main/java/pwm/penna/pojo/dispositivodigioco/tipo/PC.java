package pwm.penna.pojo.dispositivodigioco.tipo;

import java.sql.Date;

import pwm.penna.pojo.dispositivodigioco.DispositivoDiGioco;

public class PC extends DispositivoDiGioco {
	private static final long serialVersionUID = 1L;
	
	public final static String DISCRIMINATOR = "PC";
	
	private String windows;
	
	public PC() {
        super();
    }

    public PC(Integer id, Date dataAcquisizione, String windows) {
        super(id, dataAcquisizione);
        this.windows = windows;
    }

    public PC(DispositivoDiGioco d, String windows) {
        this(d.getId(), d.getDataAcquisizione(), windows);
    }

	public String getWindows() {
		return windows;
	}

	public void setWindows(String windows) {
		this.windows = windows;
	}
}
