package pwm.penna.model.home;

import org.json.JSONObject;

import android.util.Log;

public class HomeJSONDAOImpl implements HomeJSONDAO {
	private static final String TAG = "HomeJSONDAOImpl";

	@Override
	public Home getHome(JSONObject jsonObject) {
		Home home = new Home();

		try {
			home.setCassieri(jsonObject.getLong(HomeJSONContract.CASSIERI));
			home.setDdg(jsonObject.getLong(HomeJSONContract.DDG));
			home.setDipendenti(jsonObject.getLong(HomeJSONContract.DIPENDENTI));
			home.setDirigenti(jsonObject.getLong(HomeJSONContract.DIRIGENTI));
			home.setSale(jsonObject.getLong(HomeJSONContract.SALE));
			home.setSoci(jsonObject.getLong(HomeJSONContract.SOCI));
			home.setTecnici(jsonObject.getLong(HomeJSONContract.TECNICI));
		} catch (Exception e) {
			Log.e(TAG, e.getMessage() + e.getCause());
		}
		return home;
	}
}
