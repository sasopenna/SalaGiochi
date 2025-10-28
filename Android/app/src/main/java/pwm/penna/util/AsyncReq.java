package pwm.penna.util;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONObject;

import pwm.penna.activity.AsyncActivity;
import pwm.penna.R;

public class AsyncReq extends AsyncTask<InternetConnection, Void, JSONObject> {
	private static final String TAG = "AsyncReq";

	private ProgressDialog progressDialog;
	private Activity activity;
	private String dtitle;
	private String dcontent;
	private String url;

	public AsyncReq(Activity a, String dtitle, String dcontent, String url) {
		this.activity = a;
		this.dtitle = dtitle;
		this.dcontent = dcontent;
		this.url = url;
	}

	protected void onPreExecute() {
		// TODO Auto-generated method stub
		super.onPreExecute();
		activity.runOnUiThread(new Runnable()
		{
			public void run()
			{
				progressDialog = ProgressDialog.show(activity, dtitle, dcontent+"\n"+url, true);
			}
		});
	}

	@Override
	protected void onPostExecute(JSONObject jsonObject) {
		// TODO Auto-generated method stub
		super.onPostExecute(jsonObject);
		
		if(activity != null) {
			((AsyncActivity) activity).setResult(jsonObject);
		}

		if(progressDialog != null)
			progressDialog.dismiss();
	}

	@Override
	protected JSONObject doInBackground(InternetConnection... params) {
		try {
			JSONObject jsonObject = new JSONObject(params[0].getHttpSource());
			return jsonObject;
		} catch (Exception e) {
			Log.e(TAG, e.getMessage() + e.getCause());
			return null;
		}
	}

	// riuso del codice
	public static void executeEndpoint(Activity activity, String endpoint) {
		final String url = activity.getString(R.string.action) + endpoint;
		InternetConnection internetConnection = new InternetConnection(url);
		AsyncReq asyncReq = new AsyncReq(activity, endpoint, "", url);
		asyncReq.execute(internetConnection);
	}
}
