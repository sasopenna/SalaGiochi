package pwm.penna.pojo.cassiere;

import java.util.List;

public interface CassiereDAO {
	public Cassiere getCassiere(Integer c);
	public long countCassieri();
	public List<Cassiere> getLista();
	public boolean eliminaCassiere(Integer c);
	public boolean creaCassiere(Cassiere c);
	public boolean aggiornaCassiere(Cassiere c);
}
