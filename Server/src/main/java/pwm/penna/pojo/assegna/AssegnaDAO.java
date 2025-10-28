package pwm.penna.pojo.assegna;

import java.util.List;

public interface AssegnaDAO {
	public Assegna getAssegnazione(Integer a);
	public List<Assegna> getLista();
	public boolean aggiornaAssegnazione(Assegna a);
	public boolean creaAssegnazione(Assegna a);
	public boolean eliminaAssegnazione(Integer a);
}
