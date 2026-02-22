package pwm.penna.pojo.salagiochi;

import java.util.List;

public interface SalaGiochiDAO {
	public SalaGiochi getSala(Integer s);
	public List<SalaGiochi> getLista();
	public long countSale();
	
	public boolean aggiornaSala(SalaGiochi s);
	public boolean creaSala(SalaGiochi s);
	public boolean eliminaSala(Integer s);
	public SalaGiochi getSalaAndPostazioni(Integer s);
}
