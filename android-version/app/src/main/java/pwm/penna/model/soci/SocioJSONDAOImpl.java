package pwm.penna.model.soci;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import pwm.penna.model.profilo.ProfiloJSONDAOImpl;

public class SocioJSONDAOImpl implements SocioJSONDAO {
	private static final String TAG = "SocioJSONDAOImpl";

	@Override
	public Socio getSocio(JSONObject o) {
		Socio s = new Socio();

		try {
			s.setProfilo(new ProfiloJSONDAOImpl().getProfilo(o.getJSONObject(SocioJSONContract.PROFILO)));

			s.setMembroDal(java.sql.Date.valueOf(o.getString(SocioJSONContract.MEMBRO_DAL).substring(0, 10)));
			s.setNumeroCliente(o.getInt(SocioJSONContract.NUMERO_CLIENTE));
			s.setPunteggio(o.getInt(SocioJSONContract.PUNTEGGIO));
		} catch (Exception e) {
			Log.e(TAG, e.getMessage() + e.getCause());
		}

		return s;
	}

	@Override
	public ArrayList<Socio> getSoci(JSONObject jsonObject) {
		ArrayList<Socio> soci = new ArrayList<>();

		try {
			JSONArray jsonArray = jsonObject.getJSONArray(SocioJSONContract.ARRAY);
			for(int j = 0; j < jsonArray.length(); j++) {
				JSONObject o = jsonArray.getJSONObject(j);

				soci.add(getSocio(o));
			}
		} catch (Exception e) {
			Log.e(TAG, e.getMessage() + e.getCause());
		}

		return soci;
	}
}
