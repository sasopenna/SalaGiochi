package pwm.penna.pojo.socio;

import java.util.List;

public interface SocioDAO {
	public Socio getSocio(Integer s);
	public long countSoci();
	public long countSociPerSesso(String sesso);
	public List<Socio> getLista();
	public List<Socio> orderSoci(String param, String ordering, int limit);
	
	public boolean aggiornaSocio(Socio s);
	boolean registraSocio(Socio s);
	boolean creaSocio(Socio s);
	boolean eliminaSocio(Integer s);
}
