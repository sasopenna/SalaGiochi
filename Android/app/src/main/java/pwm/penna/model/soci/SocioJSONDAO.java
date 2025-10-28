package pwm.penna.model.soci;

import org.json.JSONObject;

import java.util.ArrayList;

public interface SocioJSONDAO {
	public abstract ArrayList<Socio> getSoci(JSONObject jsonObject);
	public abstract Socio getSocio(JSONObject jsonObject);
}
