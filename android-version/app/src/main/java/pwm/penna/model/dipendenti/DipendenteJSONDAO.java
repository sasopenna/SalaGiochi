package pwm.penna.model.dipendenti;

import org.json.JSONObject;

import java.util.ArrayList;

import pwm.penna.model.dipendenti.pojo.*;

public interface DipendenteJSONDAO {
	public abstract ArrayList<Dirigente> getDirigenti(JSONObject jsonObject);
	public abstract ArrayList<Cassiere> getCassieri(JSONObject jsonObject);
	public abstract ArrayList<Tecnico> getTecnici(JSONObject jsonObject);
}
