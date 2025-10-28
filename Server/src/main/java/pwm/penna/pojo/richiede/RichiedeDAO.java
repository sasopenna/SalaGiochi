package pwm.penna.pojo.richiede;

import java.util.List;

import pwm.penna.pojo.salagiochi.SalaGiochi;

public interface RichiedeDAO {
	public Richiede getRichiesta(Integer r);
	public long countRichiestePerConsole(Class<?> console);
	public List<Richiede> getLista();
	public List<Richiede> getListaNonAssegnate();
	public boolean aggiornaRichiesta(Richiede r);
	public boolean creaRichiesta(Richiede r);
	public boolean eliminaRichiesta(Integer r);
	public List<Richiede> getListaNonAssegnatePerSala(SalaGiochi s);
}
