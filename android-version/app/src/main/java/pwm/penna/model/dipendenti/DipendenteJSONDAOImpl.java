package pwm.penna.model.dipendenti;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.sql.Time;
import java.util.ArrayList;

import pwm.penna.model.dipendenti.pojo.Cassiere;
import pwm.penna.model.dipendenti.pojo.Dipendente;
import pwm.penna.model.dipendenti.pojo.Dirigente;
import pwm.penna.model.dipendenti.pojo.Tecnico;
import pwm.penna.model.profilo.ProfiloJSONDAOImpl;
import pwm.penna.model.sale.SalaGiochiJSONDAOImpl;

public class DipendenteJSONDAOImpl implements DipendenteJSONDAO {
	private static final String TAG = "DipendenteJSONDAOImpl";

	@Override
	public ArrayList<Dirigente> getDirigenti(JSONObject jsonObject) {
		ArrayList<Dirigente> res = new ArrayList<>();

		try {
			JSONArray jsonArray = jsonObject.getJSONArray(DipendenteJSONContract.ARRAY);
			for(int j = 0; j < jsonArray.length(); j++) {
				JSONObject o = jsonArray.getJSONObject(j);

				Dirigente t = (Dirigente) getDipendente(new Dirigente(), o);
				t.setEsperienza(o.getInt(DipendenteJSONContract.DirigenteJSONContract.ESPERIENZA));
				t.setPeriodo(o.getInt(DipendenteJSONContract.DirigenteJSONContract.PERIODO));
				t.setSale(new SalaGiochiJSONDAOImpl().getSale(o));

				res.add(t);
			}
		} catch (Exception e) {
			Log.e(TAG, e.getMessage() + e.getCause());
		}

		return res;
	}

	@Override
	public ArrayList<Cassiere> getCassieri(JSONObject jsonObject) {
		ArrayList<Cassiere> res = new ArrayList<>();

		try {
			JSONArray jsonArray = jsonObject.getJSONArray(DipendenteJSONContract.ARRAY);
			for(int j = 0; j < jsonArray.length(); j++) {
				JSONObject o = jsonArray.getJSONObject(j);

				Cassiere t = (Cassiere) getDipendente(new Cassiere(), o);
				t.setSportello(o.getInt(DipendenteJSONContract.CassiereJSONContract.SPORTELLO));
				t.setSalaGiochi(new SalaGiochiJSONDAOImpl().getSala(o.getJSONObject(DipendenteJSONContract.CassiereJSONContract.SALA_GIOCHI)));

				res.add(t);
			}
		} catch (Exception e) {
			Log.e(TAG, e.getMessage() + e.getCause());
		}

		return res;
	}

	@Override
	public ArrayList<Tecnico> getTecnici(JSONObject jsonObject) {
		ArrayList<Tecnico> res = new ArrayList<>();

		try {
			JSONArray jsonArray = jsonObject.getJSONArray(DipendenteJSONContract.ARRAY);
			for(int j = 0; j < jsonArray.length(); j++) {
				JSONObject o = jsonArray.getJSONObject(j);

				Tecnico t = (Tecnico) getDipendente(new Tecnico(), o);
				t.setSpecializzazione(o.getString(DipendenteJSONContract.TecnicoJSONContract.SPECIALIZZAZIONE));

				res.add(t);
			}
		} catch (Exception e) {
			Log.e(TAG, e.getMessage() + e.getCause());
		}

		return res;
	}

	private Dipendente getDipendente(Dipendente d, JSONObject o) throws JSONException {
		d.setProfilo(new ProfiloJSONDAOImpl().getProfilo(o.getJSONObject(DipendenteJSONContract.PROFILO)));

		d.setIdDipendente(o.getInt(DipendenteJSONContract.ID_DIPENDENTE));
		d.setInizioTurno(Time.valueOf(o.getString(DipendenteJSONContract.INIZIO_TURNO).substring(11)));
		d.setFineTurno(Time.valueOf(o.getString(DipendenteJSONContract.FINE_TURNO).substring(11)));
		d.setSalario(o.getDouble(DipendenteJSONContract.SALARIO));
		return d;
	}
}
