package pwm.penna.model.statistiche;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import pwm.penna.model.soci.Socio;
import pwm.penna.model.soci.SocioJSONDAOImpl;

public class StatisticheJSONDAOImpl implements StatisticheJSONDAO {
	private static final String TAG = "StatisticheJSONDAOImpl";

	@Override
	public Statistiche getStatistiche(JSONObject o) {
		SocioJSONDAOImpl socioDAO = new SocioJSONDAOImpl();
		Statistiche s = new Statistiche();

		try {
			s.setDonna(o.getInt(StatisticheJSONContract.DONNA));
			s.setUomo(o.getInt(StatisticheJSONContract.UOMO));
			s.setPc(o.getInt(StatisticheJSONContract.PC));
			s.setPlay(o.getInt(StatisticheJSONContract.PLAY));
			s.setXbox(o.getInt(StatisticheJSONContract.XBOX));

			JSONArray top5Array = o.getJSONArray(StatisticheJSONContract.TOP5);
			List<Socio> top5List = new ArrayList<>();
			for (int i = 0; i < top5Array.length(); i++) {
				JSONObject socio = top5Array.getJSONObject(i);
				top5List.add(socioDAO.getSocio(socio));
			}
			s.setTop5(top5List);

			JSONArray fedeli5Array = o.getJSONArray(StatisticheJSONContract.FEDELI5);
			List<Socio> fedeli5List = new ArrayList<>();
			for (int i = 0; i < fedeli5Array.length(); i++) {
				JSONObject socio = fedeli5Array.getJSONObject(i);
				fedeli5List.add(socioDAO.getSocio(socio));
			}
			s.setFedeli5(fedeli5List);
		} catch (Exception e) {
			Log.e(TAG, e.getMessage() + e.getCause());
		}

		return s;
	}
}
