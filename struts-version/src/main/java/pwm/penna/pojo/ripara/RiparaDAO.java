package pwm.penna.pojo.ripara;

import java.util.List;

public interface RiparaDAO {
	public Ripara getRiparazione(Integer r);
	public List<Ripara> getLista();
	public boolean aggiornaRiparazione(Ripara ripara);
	public boolean eliminaRiparazione(Integer id);
	public boolean creaRiparazione(Ripara ripara);
}
