package pwm.penna.pojo.dirigente;

import java.util.List;

public interface DirigenteDAO {
	public Dirigente getDirigente(int d);
	public List<Dirigente> getLista();
	public long countDirigenti();
	public boolean eliminaDirigente(Integer id);
	public boolean creaDirigente(Dirigente dirigente);
	public boolean aggiornaDirigente(Dirigente dirigente);
}
