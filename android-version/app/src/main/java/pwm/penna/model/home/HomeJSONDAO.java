package pwm.penna.model.home;

import org.json.JSONObject;

public interface HomeJSONDAO {
	public abstract Home getHome(JSONObject jsonObject);
}
