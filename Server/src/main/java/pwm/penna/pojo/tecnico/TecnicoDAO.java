package pwm.penna.pojo.tecnico;

import java.util.List;

public interface TecnicoDAO {
	public Tecnico getTecnico(int t);
	public long countTecnici();
	public List<Tecnico> getLista();
	
	public boolean eliminaTecnico(Integer t);
	public boolean creaTecnico(Tecnico t);
	public boolean aggiornaTecnico(Tecnico t);
}
