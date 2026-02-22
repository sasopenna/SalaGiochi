package pwm.penna.model.profilo;

import org.json.JSONObject;

public interface ProfiloJSONDAO {
	public abstract Profilo getProfilo(JSONObject jsonObject);
}
