package pwm.penna.pojo.postazione;

import java.util.List;

public interface PostazioneDAO {
	public Postazione getPostazione(Integer p);
	public List<Postazione> getLista();
	public boolean aggiornaPostazione(Postazione p);
	boolean creaPostazione(Postazione p);
	boolean eliminaPostazione(Integer p);
}