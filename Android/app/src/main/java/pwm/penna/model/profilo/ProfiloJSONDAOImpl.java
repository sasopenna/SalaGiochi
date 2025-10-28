package pwm.penna.model.profilo;

import android.util.Log;

import org.json.JSONObject;

public class ProfiloJSONDAOImpl implements ProfiloJSONDAO {
	private static final String TAG = "ProfiloJSONDAOImpl";

	@Override
	public Profilo getProfilo(JSONObject o) {
		Profilo p = new Profilo();

		try {
			p.setNome(o.getString(ProfiloJSONContract.NOME));
			p.setCognome(o.getString(ProfiloJSONContract.COGNOME));
			p.setEmail(o.getString(ProfiloJSONContract.EMAIL));
			p.setCap(o.getInt(ProfiloJSONContract.CAP));
			p.setCitta(o.getString(ProfiloJSONContract.CITTA));
			p.setCodiceFiscale(o.getString(ProfiloJSONContract.CODICE_FISCALE));
			p.setDataDiNascita(java.sql.Date.valueOf(o.getString(ProfiloJSONContract.DATA_DI_NASCITA).substring(0, 10)));
			p.setNumeroCivico(o.getInt(ProfiloJSONContract.NUMERO_CIVICO));
			p.setSesso(o.getString(ProfiloJSONContract.SESSO));
			p.setTelefono(o.getLong(ProfiloJSONContract.TELEFONO));
			p.setVia(o.getString(ProfiloJSONContract.VIA));
		} catch (Exception e) {
			Log.e(TAG, e.getMessage() + e.getCause());
		}

		return p;
	}
}
