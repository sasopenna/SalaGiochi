package pwm.penna.pojo.dispositivodigioco;

import java.util.List;

public interface DispositivoDiGiocoDAO {
	public DispositivoDiGioco getDispositivo(Integer d);
	public long countDispositivi();
	public List<DispositivoDiGioco> getLista();
	public List<DispositivoDiGioco> getListaNotTaken(DispositivoDiGioco d);
	public boolean eliminaDispositivo(Integer d);
	public boolean creaDispositivo(DispositivoDiGioco d);
	public boolean aggiornaDispositivo(DispositivoDiGioco d);
}