package pwm.penna.model.statistiche;

import org.json.JSONObject;

public interface StatisticheJSONDAO {
	public abstract Statistiche getStatistiche(JSONObject jsonObject);
}
