package pwm.penna.model.sale;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public interface SalaGiochiJSONDAO {
	public abstract ArrayList<SalaGiochi> getSale(JSONObject jsonObject);
    public abstract SalaGiochi getSala(JSONObject o) throws JSONException;
}
