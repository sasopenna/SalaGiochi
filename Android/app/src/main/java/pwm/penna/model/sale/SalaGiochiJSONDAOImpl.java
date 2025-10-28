package pwm.penna.model.sale;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class SalaGiochiJSONDAOImpl implements SalaGiochiJSONDAO {
	private static final String TAG = "SalaGiochiJSONDAOImpl";

	@Override
	public ArrayList<SalaGiochi> getSale(JSONObject jsonObject) {
		ArrayList<SalaGiochi> sale = new ArrayList<>();

		try {
			JSONArray jsonArray = jsonObject.getJSONArray(SalaGiochiJSONContract.ARRAY);
			for(int j = 0; j < jsonArray.length(); j++) {
				JSONObject o = jsonArray.getJSONObject(j);
				sale.add(getSala(o));
			}
		} catch (Exception e) {
			Log.e(TAG, e.getMessage() + e.getCause());
		}

		return sale;
	}

	@Override
	public SalaGiochi getSala(JSONObject o) throws JSONException {
		SalaGiochi s = new SalaGiochi();
		s.setCapienza(o.getInt(SalaGiochiJSONContract.CAPIENZA));
		s.setCodice(o.getInt(SalaGiochiJSONContract.CODICE));
		s.setNome(o.getString(SalaGiochiJSONContract.NOME));
		s.setOrarioApertura(java.sql.Time.valueOf(o.getString(SalaGiochiJSONContract.ORARIO_APERTURA).substring(11)));
		s.setOrarioChiusura(java.sql.Time.valueOf(o.getString(SalaGiochiJSONContract.ORARIO_CHIUSURA).substring(11)));

		JSONObject i = o.getJSONObject(SalaGiochiJSONContract.IndirizzoJSONContract.INDIRIZZO);
		Indirizzo ind = new Indirizzo();
		ind.setCap(i.getInt(SalaGiochiJSONContract.IndirizzoJSONContract.CAP));
		ind.setCitta(i.getString(SalaGiochiJSONContract.IndirizzoJSONContract.CITTA));
		ind.setVia(i.getString(SalaGiochiJSONContract.IndirizzoJSONContract.VIA));
		ind.setProvincia(i.getString(SalaGiochiJSONContract.IndirizzoJSONContract.PROVINCIA));
		ind.setRegione(i.getString(SalaGiochiJSONContract.IndirizzoJSONContract.REGIONE));
		ind.setNumeroCivico(i.getInt(SalaGiochiJSONContract.IndirizzoJSONContract.NUMERO_CIVICO));

		s.setIndirizzo(ind);
		return s;
	}
}
